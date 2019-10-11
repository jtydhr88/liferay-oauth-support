package com.liferay.oauthlogin.portlet;

import com.liferay.expando.kernel.model.*;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.oauthlogin.constants.OAuthLoginAdminPortletKeys;
import com.liferay.oauthlogin.model.OAuthConnection;
import com.liferay.oauthlogin.service.OAuthConnectionLocalServiceUtil;
import com.liferay.oauthlogin.util.WebKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.oauth.terry.*;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author terryjia
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OAuthLoginDisplay",
		"javax.portlet.init-param.template-path=/display/",
		"javax.portlet.init-param.view-template=/display/view.jsp",
		"javax.portlet.name=" + OAuthLoginAdminPortletKeys.OAUTHLOGINDISPLAY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OAuthLoginDisplayPortlet extends MVCPortlet {

	public void getAuthorizeURL(
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		long oAuthConnectionId = ParamUtil.getLong(
				actionRequest, "oAuthConnectionId");

		OAuthConnection oAuthConnection =
				OAuthConnectionLocalServiceUtil.getOAuthConnection(
						oAuthConnectionId);

		String authorizeURL = oAuthConnection.getAuthorizeURL();

		String accessTokenURL = oAuthConnection.getAccessTokenURL();

		Verb accessTokenVerb = Verb.GET;

		if (oAuthConnection.getAccessTokenVerb() == OAuthConstants.POST) {
			accessTokenVerb = Verb.POST;
		}

		OAuthManagerImpl oAuthManager = null;

		TokenImpl requestToken = null;

		String redirectURL = oAuthConnection.getRedirectURL();

		redirectURL = HttpUtil.addParameter(
				redirectURL, "oAuthConnectionId", String.valueOf(
						oAuthConnectionId));

		if (oAuthConnection.getOAuthVersion() == OAuthConstants.OAUTH_10A) {
			Verb requestTokenVerb = Verb.GET;

			if (oAuthConnection.getRequestTokenVerb() == OAuthConstants.POST) {
				requestTokenVerb = Verb.POST;
			}

			authorizeURL = authorizeURL + "?oauth_token=%s";

			oAuthManager = new OAuthManagerImpl(
					oAuthConnection.getKey(), oAuthConnection.getSecret(),
					accessTokenURL, authorizeURL,
					oAuthConnection.getRequestTokenURL(), redirectURL,
					oAuthConnection.getScope(), accessTokenVerb, requestTokenVerb,
					oAuthConnection.getSignatureServiceType());

			requestToken = oAuthManager.getRequestToken();

			HttpServletRequest request = PortalUtil.getHttpServletRequest(
					actionRequest);

			HttpSession session = request.getSession();

			session.setAttribute("requestToken", requestToken);
		}
		else {
			authorizeURL =
					authorizeURL +
							"?client_id=%s&redirect_uri=%s&response_type=code";

			accessTokenURL =
					oAuthConnection.getAccessTokenURL() +
							"?grant_type=authorization_code";

			if (Validator.isNotNull(oAuthConnection.getScope())) {
				authorizeURL = authorizeURL + "&scope=%s";
			}

			oAuthManager = new OAuthManagerImpl(
					oAuthConnection.getKey(), oAuthConnection.getSecret(),
					accessTokenURL, authorizeURL, redirectURL,
					oAuthConnection.getScope(), accessTokenVerb,
					oAuthConnection.getAccessTokenExtractorType());

			requestToken = OAuthFactoryImpl.createToken(
					oAuthConnection.getKey(), oAuthConnection.getSecret());
		}

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put(
				"authorizeURL", oAuthManager.getAuthorizeURL(requestToken));

		writeJSON(actionRequest, actionResponse, jsonObject);
	}

	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
				renderRequest);

		HttpSession session = request.getSession();

		String errorCode = (String)session.getAttribute("errorCode");

		if (Validator.isNotNull(errorCode)) {
			SessionErrors.add(renderRequest, errorCode);

			session.removeAttribute("errorCode");
		}

		super.render(renderRequest, renderResponse);
	}

	public void unbindSocialAccount(
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		long userId = themeDisplay.getUserId();

		long companyId = themeDisplay.getCompanyId();

		String oAuthConnectionId = ParamUtil.getString(
				actionRequest, "oAuthConnectionId");

		String expandoColumnName = oAuthConnectionId + "_social_account_id";

		ExpandoValueLocalServiceUtil.deleteValue(
				companyId, User.class.getName(),
				ExpandoTableConstants.DEFAULT_TABLE_NAME, expandoColumnName,
				userId);
	}

}
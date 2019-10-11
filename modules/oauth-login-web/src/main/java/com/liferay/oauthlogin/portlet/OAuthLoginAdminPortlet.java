package com.liferay.oauthlogin.portlet;

import com.liferay.expando.kernel.model.*;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.oauthlogin.constants.OAuthLoginAdminPortletKeys;

import com.liferay.oauthlogin.model.OAuthConnection;
import com.liferay.oauthlogin.service.OAuthConnectionLocalService;
import com.liferay.oauthlogin.service.OAuthConnectionLocalServiceUtil;
import com.liferay.oauthlogin.util.OAuthConnectionConstants;
import com.liferay.oauthlogin.util.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.File;
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
		"javax.portlet.display-name=OAuthLoginAdmin",
		"javax.portlet.init-param.template-path=/admin/",
		"javax.portlet.init-param.view-template=/admin/view.jsp",
		"javax.portlet.name=" + OAuthLoginAdminPortletKeys.OAUTHLOGINADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OAuthLoginAdminPortlet extends MVCPortlet {

	public void deleteOAuthConnection(
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		long oAuthConnectionId = ParamUtil.getLong(
				actionRequest, "oAuthConnectionId");

		OAuthConnectionLocalServiceUtil.deleteOAuthConnection(
				oAuthConnectionId);
	}

	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {
			OAuthConnection oAuthConnection = null;

			long oAuthConnectionId = ParamUtil.getLong(
					renderRequest, "oAuthConnectionId");

			if (oAuthConnectionId > 0) {
				oAuthConnection =
						OAuthConnectionLocalServiceUtil.getOAuthConnection(
								oAuthConnectionId);
			}

			renderRequest.setAttribute(
					WebKeys.OAUTH_CONNECTION, oAuthConnection);
		}
		catch (PortalException e) {
		}
		catch (SystemException e) {
		}

		renderRequest.setAttribute("oauthConnectionLocalService", _oauthConnectionLocalService);

		super.render(renderRequest, renderResponse);
	}

	public void updateOAuthConnection(
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		UploadPortletRequest uploadPortletRequest =
				PortalUtil.getUploadPortletRequest(actionRequest);

		long oAuthConnectionId = ParamUtil.getLong(
				uploadPortletRequest, "oAuthConnectionId");

		boolean enabled = ParamUtil.getBoolean(uploadPortletRequest, "enabled");
		String name = ParamUtil.getString(uploadPortletRequest, "name");
		String description = ParamUtil.getString(
				uploadPortletRequest, "description");
		int oAuthVersion = ParamUtil.getInteger(
				uploadPortletRequest, "oAuthVersion");
		String key = ParamUtil.getString(uploadPortletRequest, "key");
		String secret = ParamUtil.getString(uploadPortletRequest, "secret");
		String scope = ParamUtil.getString(uploadPortletRequest, "scope");
		String authorizeURL = ParamUtil.getString(
				uploadPortletRequest, "authorizeURL");
		String accessTokenURL = ParamUtil.getString(
				uploadPortletRequest, "accessTokenURL");
		int accessTokenVerb = ParamUtil.getInteger(
				uploadPortletRequest, "accessTokenVerb");
		int accessTokenExtractorType = ParamUtil.getInteger(
				uploadPortletRequest, "accessTokenExtractorType");
		String requestTokenURL = ParamUtil.getString(
				uploadPortletRequest, "requestTokenURL");
		int requestTokenVerb = ParamUtil.getInteger(
				uploadPortletRequest, "requestTokenVerb");
		int signatureServiceType = ParamUtil.getInteger(
				uploadPortletRequest, "signatureServiceType");
		String redirectURL = ParamUtil.getString(
				uploadPortletRequest, "redirectURL");
		String socialAccountIdURL = ParamUtil.getString(
				uploadPortletRequest, "socialAccountIdURL");
		int socialAccountIdURLVerb = ParamUtil.getInteger(
				uploadPortletRequest, "socialAccountIdURLVerb");
		String socialAccountIdField = ParamUtil.getString(
				uploadPortletRequest, "socialAccountIdField");
		int socialAccountIdType = ParamUtil.getInteger(
				uploadPortletRequest, "socialAccountIdType");
		String socialAccountIdScript = ParamUtil.getString(
				uploadPortletRequest, "socialAccountIdScript");

		File icon = uploadPortletRequest.getFile("icon");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				actionRequest);

		if (oAuthConnectionId <= 0) {
			OAuthConnection oAuthConnection = null;

			ExpandoTable expandoTable = null;

			ExpandoColumn expandoColumn = null;

			oAuthConnection =
					OAuthConnectionLocalServiceUtil.addOAuthConnection(
							enabled, name, description, oAuthVersion, key, secret,
							scope, authorizeURL, accessTokenURL, accessTokenVerb,
							accessTokenExtractorType, requestTokenURL, requestTokenVerb,
							signatureServiceType, redirectURL, socialAccountIdURL,
							socialAccountIdURLVerb, socialAccountIdField,
							socialAccountIdType, socialAccountIdScript, icon,
							serviceContext);

			try {
				expandoTable = ExpandoTableLocalServiceUtil.addTable(
						PortalUtil.getCompanyId(uploadPortletRequest),
						User.class.getName(),
						ExpandoTableConstants.DEFAULT_TABLE_NAME);
			}
			catch (Exception e) {
				expandoTable = ExpandoTableLocalServiceUtil.getTable(
						PortalUtil.getCompanyId(uploadPortletRequest),
						User.class.getName(),
						ExpandoTableConstants.DEFAULT_TABLE_NAME);
			}

			expandoColumn = ExpandoColumnLocalServiceUtil.addColumn(
					expandoTable.getTableId(),
					oAuthConnection.getOAuthConnectionId() + "_social_account_id",
					ExpandoColumnConstants.STRING);

			ExpandoBridge expandoBridge =
					ExpandoBridgeFactoryUtil.getExpandoBridge(
							PortalUtil.getCompanyId(uploadPortletRequest),
							User.class.getName());

			UnicodeProperties properties = expandoBridge.getAttributeProperties(
					expandoColumn.getName());

			properties.setProperty(
					"hidden", OAuthConnectionConstants.EXPANDO_COLUMN_HIDDEN);

			expandoBridge.setAttributeProperties(
					expandoColumn.getName(), properties);

			String[] actionIds = {ActionKeys.UPDATE};

			Role guest = RoleLocalServiceUtil.getRole(
				PortalUtil.getCompanyId(uploadPortletRequest),
				RoleConstants.GUEST);

			ResourcePermissionLocalServiceUtil.setResourcePermissions(
				PortalUtil.getCompanyId(actionRequest),
				ExpandoColumn.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL,
				String.valueOf(expandoColumn.getColumnId()), guest.getRoleId(),
				actionIds);
		}
		else {
			OAuthConnectionLocalServiceUtil.updateOAuthConnection(
				oAuthConnectionId, enabled, name, description, oAuthVersion,
				key, secret, scope, authorizeURL, accessTokenURL,
				accessTokenVerb, accessTokenExtractorType, requestTokenURL,
				requestTokenVerb, signatureServiceType, redirectURL,
				socialAccountIdURL, socialAccountIdURLVerb,
				socialAccountIdField, socialAccountIdType,
				socialAccountIdScript, icon, serviceContext);
		}
	}

	@Reference(unbind = "-")
	protected void setOAuthConnectionLocalService(OAuthConnectionLocalService oauthConnectionLocalService) {
		_oauthConnectionLocalService = oauthConnectionLocalService;
	}

	private OAuthConnectionLocalService _oauthConnectionLocalService;

}
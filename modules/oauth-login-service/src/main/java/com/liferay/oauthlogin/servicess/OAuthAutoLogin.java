package com.liferay.oauthlogin.servicess;

import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.oauthlogin.model.OAuthConnection;
import com.liferay.oauthlogin.service.OAuthConnectionLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import com.liferay.portal.kernel.security.auto.login.BaseAutoLogin;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Component(immediate = true, service = AutoLogin.class)
public class OAuthAutoLogin extends BaseAutoLogin {

    @Override
    protected String[] doLogin(
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.println("OAuthAutoLogin entry");

        HttpSession session = request.getSession();

        Object socialAccountIdObj = session.getAttribute("socialAccountId");

        Object oAuthConnectionIdObj = session.getAttribute("oAuthConnectionId");

        long companyId = PortalUtil.getCompanyId(request);

        if ((socialAccountIdObj == null) || (oAuthConnectionIdObj == null)) {
            return null;
        }

        session.removeAttribute("socialAccountId");

        session.removeAttribute("oAuthConnectionId");

        String socialAccountId = String.valueOf(socialAccountIdObj);

        long oAuthConnectionId = (Long)oAuthConnectionIdObj;

        OAuthConnection oAuthConnection =
                OAuthConnectionLocalServiceUtil.getOAuthConnection(
                        oAuthConnectionId);

        if (!oAuthConnection.isEnabled()) {
            return null;
        }

        User user = getUser(companyId, oAuthConnectionId, socialAccountId);

        if (user == null) {
            return null;
        }

        String[] credentials = new String[3];

        credentials[0] = String.valueOf(user.getUserId());
        credentials[2] = Boolean.FALSE.toString();
        credentials[1] = user.getPassword();


        return credentials;
    }

    protected User getUser(
            long companyId, long oAuthConnectionId, String socialAccountId) {

        User user = null;

        try {
            List<ExpandoValue> expandoValues =
                ExpandoValueLocalServiceUtil.getColumnValues(
                    companyId, User.class.getName(),
                    ExpandoTableConstants.DEFAULT_TABLE_NAME,
                    oAuthConnectionId + "_social_account_id", socialAccountId,
                    QueryUtil.ALL_POS, QueryUtil.ALL_POS);

            if (expandoValues.size() > 0) {
                long userId = expandoValues.get(0).getClassPK();

                user = _userLocalService.getUser(userId);
            }
        }
        catch (PortalException pe) {
        }
        catch (SystemException pe) {
        }

        return user;
    }

    @Reference(unbind = "-")
    protected void setUserLocalService(UserLocalService userLocalService) {
        _userLocalService = userLocalService;
    }

    private UserLocalService _userLocalService;

}

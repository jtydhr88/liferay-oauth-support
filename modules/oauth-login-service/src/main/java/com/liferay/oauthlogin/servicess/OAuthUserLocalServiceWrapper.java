package com.liferay.oauthlogin.servicess;

import com.liferay.portal.kernel.model.User;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceWrapper;
import com.liferay.portal.kernel.util.GetterUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

/**
 * @author terryjia
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class OAuthUserLocalServiceWrapper extends UserLocalServiceWrapper {

	public OAuthUserLocalServiceWrapper() {
		super(null);
	}

	@Override
	public User addUserWithWorkflow(
			long creatorUserId, long companyId, boolean autoPassword,
			String password1, String password2, boolean autoScreenName,
			String screenName, String emailAddress, long facebookId,
			String openId, Locale locale, String firstName,
			String middleName, String lastName, long prefixId, long suffixId,
			boolean male, int birthdayMonth, int birthdayDay, int birthdayYear,
			String jobTitle, long[] groupIds, long[] organizationIds,
			long[] roleIds, long[] userGroupIds, boolean sendEmail,
			ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		boolean isSocialLogin = GetterUtil.getBoolean(
				serviceContext.getAttribute("isSocialLogin"));

		User user = null;

		if (isSocialLogin) {
			user = _userLocalService.addUser(
					creatorUserId, companyId, autoPassword, password1, password2,
					autoScreenName, screenName, emailAddress, facebookId, openId,
					locale, firstName, middleName, lastName, prefixId, suffixId,
					male, birthdayMonth, birthdayDay, birthdayYear, jobTitle,
					groupIds, organizationIds, roleIds, userGroupIds, sendEmail,
					serviceContext);

			user = _userLocalService.updateLastLogin(
					user.getUserId(), user.getLoginIP());

			user = _userLocalService.updatePasswordReset(
					user.getUserId(), false);

			user = _userLocalService.updateEmailAddressVerified(
					user.getUserId(), true);
		}
		else {
			user = super.addUserWithWorkflow(
					creatorUserId, companyId, autoPassword, password1, password2,
					autoScreenName, screenName, emailAddress, facebookId, openId,
					locale, firstName, middleName, lastName, prefixId, suffixId,
					male, birthdayMonth, birthdayDay, birthdayYear, jobTitle,
					groupIds, organizationIds, roleIds, userGroupIds, sendEmail,
					serviceContext);
		}

		return user;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	private UserLocalService _userLocalService;

}
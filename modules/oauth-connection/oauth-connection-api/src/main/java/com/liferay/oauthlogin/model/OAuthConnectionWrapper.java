/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.oauthlogin.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link OAuthConnection}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OAuthConnection
 * @generated
 */
@ProviderType
public class OAuthConnectionWrapper
	extends BaseModelWrapper<OAuthConnection>
	implements OAuthConnection, ModelWrapper<OAuthConnection> {

	public OAuthConnectionWrapper(OAuthConnection oAuthConnection) {
		super(oAuthConnection);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("oAuthConnectionId", getOAuthConnectionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("enabled", isEnabled());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("iconId", getIconId());
		attributes.put("oAuthVersion", getOAuthVersion());
		attributes.put("key", getKey());
		attributes.put("secret", getSecret());
		attributes.put("scope", getScope());
		attributes.put("authorizeURL", getAuthorizeURL());
		attributes.put("accessTokenURL", getAccessTokenURL());
		attributes.put("accessTokenVerb", getAccessTokenVerb());
		attributes.put(
			"accessTokenExtractorType", getAccessTokenExtractorType());
		attributes.put("requestTokenURL", getRequestTokenURL());
		attributes.put("requestTokenVerb", getRequestTokenVerb());
		attributes.put("signatureServiceType", getSignatureServiceType());
		attributes.put("redirectURL", getRedirectURL());
		attributes.put("socialAccountIdURL", getSocialAccountIdURL());
		attributes.put("socialAccountIdURLVerb", getSocialAccountIdURLVerb());
		attributes.put("socialAccountIdField", getSocialAccountIdField());
		attributes.put("socialAccountIdType", getSocialAccountIdType());
		attributes.put("socialAccountIdScript", getSocialAccountIdScript());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long oAuthConnectionId = (Long)attributes.get("oAuthConnectionId");

		if (oAuthConnectionId != null) {
			setOAuthConnectionId(oAuthConnectionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean enabled = (Boolean)attributes.get("enabled");

		if (enabled != null) {
			setEnabled(enabled);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long iconId = (Long)attributes.get("iconId");

		if (iconId != null) {
			setIconId(iconId);
		}

		Integer oAuthVersion = (Integer)attributes.get("oAuthVersion");

		if (oAuthVersion != null) {
			setOAuthVersion(oAuthVersion);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String secret = (String)attributes.get("secret");

		if (secret != null) {
			setSecret(secret);
		}

		String scope = (String)attributes.get("scope");

		if (scope != null) {
			setScope(scope);
		}

		String authorizeURL = (String)attributes.get("authorizeURL");

		if (authorizeURL != null) {
			setAuthorizeURL(authorizeURL);
		}

		String accessTokenURL = (String)attributes.get("accessTokenURL");

		if (accessTokenURL != null) {
			setAccessTokenURL(accessTokenURL);
		}

		Integer accessTokenVerb = (Integer)attributes.get("accessTokenVerb");

		if (accessTokenVerb != null) {
			setAccessTokenVerb(accessTokenVerb);
		}

		Integer accessTokenExtractorType = (Integer)attributes.get(
			"accessTokenExtractorType");

		if (accessTokenExtractorType != null) {
			setAccessTokenExtractorType(accessTokenExtractorType);
		}

		String requestTokenURL = (String)attributes.get("requestTokenURL");

		if (requestTokenURL != null) {
			setRequestTokenURL(requestTokenURL);
		}

		Integer requestTokenVerb = (Integer)attributes.get("requestTokenVerb");

		if (requestTokenVerb != null) {
			setRequestTokenVerb(requestTokenVerb);
		}

		Integer signatureServiceType = (Integer)attributes.get(
			"signatureServiceType");

		if (signatureServiceType != null) {
			setSignatureServiceType(signatureServiceType);
		}

		String redirectURL = (String)attributes.get("redirectURL");

		if (redirectURL != null) {
			setRedirectURL(redirectURL);
		}

		String socialAccountIdURL = (String)attributes.get(
			"socialAccountIdURL");

		if (socialAccountIdURL != null) {
			setSocialAccountIdURL(socialAccountIdURL);
		}

		Integer socialAccountIdURLVerb = (Integer)attributes.get(
			"socialAccountIdURLVerb");

		if (socialAccountIdURLVerb != null) {
			setSocialAccountIdURLVerb(socialAccountIdURLVerb);
		}

		String socialAccountIdField = (String)attributes.get(
			"socialAccountIdField");

		if (socialAccountIdField != null) {
			setSocialAccountIdField(socialAccountIdField);
		}

		Integer socialAccountIdType = (Integer)attributes.get(
			"socialAccountIdType");

		if (socialAccountIdType != null) {
			setSocialAccountIdType(socialAccountIdType);
		}

		String socialAccountIdScript = (String)attributes.get(
			"socialAccountIdScript");

		if (socialAccountIdScript != null) {
			setSocialAccountIdScript(socialAccountIdScript);
		}
	}

	/**
	 * Returns the access token extractor type of this o auth connection.
	 *
	 * @return the access token extractor type of this o auth connection
	 */
	@Override
	public int getAccessTokenExtractorType() {
		return model.getAccessTokenExtractorType();
	}

	/**
	 * Returns the access token url of this o auth connection.
	 *
	 * @return the access token url of this o auth connection
	 */
	@Override
	public String getAccessTokenURL() {
		return model.getAccessTokenURL();
	}

	/**
	 * Returns the access token verb of this o auth connection.
	 *
	 * @return the access token verb of this o auth connection
	 */
	@Override
	public int getAccessTokenVerb() {
		return model.getAccessTokenVerb();
	}

	/**
	 * Returns the authorize url of this o auth connection.
	 *
	 * @return the authorize url of this o auth connection
	 */
	@Override
	public String getAuthorizeURL() {
		return model.getAuthorizeURL();
	}

	/**
	 * Returns the company ID of this o auth connection.
	 *
	 * @return the company ID of this o auth connection
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this o auth connection.
	 *
	 * @return the create date of this o auth connection
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this o auth connection.
	 *
	 * @return the description of this o auth connection
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the enabled of this o auth connection.
	 *
	 * @return the enabled of this o auth connection
	 */
	@Override
	public boolean getEnabled() {
		return model.getEnabled();
	}

	/**
	 * Returns the icon ID of this o auth connection.
	 *
	 * @return the icon ID of this o auth connection
	 */
	@Override
	public long getIconId() {
		return model.getIconId();
	}

	/**
	 * Returns the key of this o auth connection.
	 *
	 * @return the key of this o auth connection
	 */
	@Override
	public String getKey() {
		return model.getKey();
	}

	/**
	 * Returns the modified date of this o auth connection.
	 *
	 * @return the modified date of this o auth connection
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this o auth connection.
	 *
	 * @return the name of this o auth connection
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the o auth connection ID of this o auth connection.
	 *
	 * @return the o auth connection ID of this o auth connection
	 */
	@Override
	public long getOAuthConnectionId() {
		return model.getOAuthConnectionId();
	}

	/**
	 * Returns the o auth version of this o auth connection.
	 *
	 * @return the o auth version of this o auth connection
	 */
	@Override
	public int getOAuthVersion() {
		return model.getOAuthVersion();
	}

	/**
	 * Returns the primary key of this o auth connection.
	 *
	 * @return the primary key of this o auth connection
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the redirect url of this o auth connection.
	 *
	 * @return the redirect url of this o auth connection
	 */
	@Override
	public String getRedirectURL() {
		return model.getRedirectURL();
	}

	/**
	 * Returns the request token url of this o auth connection.
	 *
	 * @return the request token url of this o auth connection
	 */
	@Override
	public String getRequestTokenURL() {
		return model.getRequestTokenURL();
	}

	/**
	 * Returns the request token verb of this o auth connection.
	 *
	 * @return the request token verb of this o auth connection
	 */
	@Override
	public int getRequestTokenVerb() {
		return model.getRequestTokenVerb();
	}

	/**
	 * Returns the scope of this o auth connection.
	 *
	 * @return the scope of this o auth connection
	 */
	@Override
	public String getScope() {
		return model.getScope();
	}

	/**
	 * Returns the secret of this o auth connection.
	 *
	 * @return the secret of this o auth connection
	 */
	@Override
	public String getSecret() {
		return model.getSecret();
	}

	/**
	 * Returns the signature service type of this o auth connection.
	 *
	 * @return the signature service type of this o auth connection
	 */
	@Override
	public int getSignatureServiceType() {
		return model.getSignatureServiceType();
	}

	/**
	 * Returns the social account ID field of this o auth connection.
	 *
	 * @return the social account ID field of this o auth connection
	 */
	@Override
	public String getSocialAccountIdField() {
		return model.getSocialAccountIdField();
	}

	/**
	 * Returns the social account ID script of this o auth connection.
	 *
	 * @return the social account ID script of this o auth connection
	 */
	@Override
	public String getSocialAccountIdScript() {
		return model.getSocialAccountIdScript();
	}

	/**
	 * Returns the social account ID type of this o auth connection.
	 *
	 * @return the social account ID type of this o auth connection
	 */
	@Override
	public int getSocialAccountIdType() {
		return model.getSocialAccountIdType();
	}

	/**
	 * Returns the social account ID url of this o auth connection.
	 *
	 * @return the social account ID url of this o auth connection
	 */
	@Override
	public String getSocialAccountIdURL() {
		return model.getSocialAccountIdURL();
	}

	/**
	 * Returns the social account ID url verb of this o auth connection.
	 *
	 * @return the social account ID url verb of this o auth connection
	 */
	@Override
	public int getSocialAccountIdURLVerb() {
		return model.getSocialAccountIdURLVerb();
	}

	/**
	 * Returns the user ID of this o auth connection.
	 *
	 * @return the user ID of this o auth connection
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this o auth connection.
	 *
	 * @return the user uuid of this o auth connection
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this o auth connection is enabled.
	 *
	 * @return <code>true</code> if this o auth connection is enabled; <code>false</code> otherwise
	 */
	@Override
	public boolean isEnabled() {
		return model.isEnabled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the access token extractor type of this o auth connection.
	 *
	 * @param accessTokenExtractorType the access token extractor type of this o auth connection
	 */
	@Override
	public void setAccessTokenExtractorType(int accessTokenExtractorType) {
		model.setAccessTokenExtractorType(accessTokenExtractorType);
	}

	/**
	 * Sets the access token url of this o auth connection.
	 *
	 * @param accessTokenURL the access token url of this o auth connection
	 */
	@Override
	public void setAccessTokenURL(String accessTokenURL) {
		model.setAccessTokenURL(accessTokenURL);
	}

	/**
	 * Sets the access token verb of this o auth connection.
	 *
	 * @param accessTokenVerb the access token verb of this o auth connection
	 */
	@Override
	public void setAccessTokenVerb(int accessTokenVerb) {
		model.setAccessTokenVerb(accessTokenVerb);
	}

	/**
	 * Sets the authorize url of this o auth connection.
	 *
	 * @param authorizeURL the authorize url of this o auth connection
	 */
	@Override
	public void setAuthorizeURL(String authorizeURL) {
		model.setAuthorizeURL(authorizeURL);
	}

	/**
	 * Sets the company ID of this o auth connection.
	 *
	 * @param companyId the company ID of this o auth connection
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this o auth connection.
	 *
	 * @param createDate the create date of this o auth connection
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this o auth connection.
	 *
	 * @param description the description of this o auth connection
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets whether this o auth connection is enabled.
	 *
	 * @param enabled the enabled of this o auth connection
	 */
	@Override
	public void setEnabled(boolean enabled) {
		model.setEnabled(enabled);
	}

	/**
	 * Sets the icon ID of this o auth connection.
	 *
	 * @param iconId the icon ID of this o auth connection
	 */
	@Override
	public void setIconId(long iconId) {
		model.setIconId(iconId);
	}

	/**
	 * Sets the key of this o auth connection.
	 *
	 * @param key the key of this o auth connection
	 */
	@Override
	public void setKey(String key) {
		model.setKey(key);
	}

	/**
	 * Sets the modified date of this o auth connection.
	 *
	 * @param modifiedDate the modified date of this o auth connection
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this o auth connection.
	 *
	 * @param name the name of this o auth connection
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the o auth connection ID of this o auth connection.
	 *
	 * @param oAuthConnectionId the o auth connection ID of this o auth connection
	 */
	@Override
	public void setOAuthConnectionId(long oAuthConnectionId) {
		model.setOAuthConnectionId(oAuthConnectionId);
	}

	/**
	 * Sets the o auth version of this o auth connection.
	 *
	 * @param oAuthVersion the o auth version of this o auth connection
	 */
	@Override
	public void setOAuthVersion(int oAuthVersion) {
		model.setOAuthVersion(oAuthVersion);
	}

	/**
	 * Sets the primary key of this o auth connection.
	 *
	 * @param primaryKey the primary key of this o auth connection
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the redirect url of this o auth connection.
	 *
	 * @param redirectURL the redirect url of this o auth connection
	 */
	@Override
	public void setRedirectURL(String redirectURL) {
		model.setRedirectURL(redirectURL);
	}

	/**
	 * Sets the request token url of this o auth connection.
	 *
	 * @param requestTokenURL the request token url of this o auth connection
	 */
	@Override
	public void setRequestTokenURL(String requestTokenURL) {
		model.setRequestTokenURL(requestTokenURL);
	}

	/**
	 * Sets the request token verb of this o auth connection.
	 *
	 * @param requestTokenVerb the request token verb of this o auth connection
	 */
	@Override
	public void setRequestTokenVerb(int requestTokenVerb) {
		model.setRequestTokenVerb(requestTokenVerb);
	}

	/**
	 * Sets the scope of this o auth connection.
	 *
	 * @param scope the scope of this o auth connection
	 */
	@Override
	public void setScope(String scope) {
		model.setScope(scope);
	}

	/**
	 * Sets the secret of this o auth connection.
	 *
	 * @param secret the secret of this o auth connection
	 */
	@Override
	public void setSecret(String secret) {
		model.setSecret(secret);
	}

	/**
	 * Sets the signature service type of this o auth connection.
	 *
	 * @param signatureServiceType the signature service type of this o auth connection
	 */
	@Override
	public void setSignatureServiceType(int signatureServiceType) {
		model.setSignatureServiceType(signatureServiceType);
	}

	/**
	 * Sets the social account ID field of this o auth connection.
	 *
	 * @param socialAccountIdField the social account ID field of this o auth connection
	 */
	@Override
	public void setSocialAccountIdField(String socialAccountIdField) {
		model.setSocialAccountIdField(socialAccountIdField);
	}

	/**
	 * Sets the social account ID script of this o auth connection.
	 *
	 * @param socialAccountIdScript the social account ID script of this o auth connection
	 */
	@Override
	public void setSocialAccountIdScript(String socialAccountIdScript) {
		model.setSocialAccountIdScript(socialAccountIdScript);
	}

	/**
	 * Sets the social account ID type of this o auth connection.
	 *
	 * @param socialAccountIdType the social account ID type of this o auth connection
	 */
	@Override
	public void setSocialAccountIdType(int socialAccountIdType) {
		model.setSocialAccountIdType(socialAccountIdType);
	}

	/**
	 * Sets the social account ID url of this o auth connection.
	 *
	 * @param socialAccountIdURL the social account ID url of this o auth connection
	 */
	@Override
	public void setSocialAccountIdURL(String socialAccountIdURL) {
		model.setSocialAccountIdURL(socialAccountIdURL);
	}

	/**
	 * Sets the social account ID url verb of this o auth connection.
	 *
	 * @param socialAccountIdURLVerb the social account ID url verb of this o auth connection
	 */
	@Override
	public void setSocialAccountIdURLVerb(int socialAccountIdURLVerb) {
		model.setSocialAccountIdURLVerb(socialAccountIdURLVerb);
	}

	/**
	 * Sets the user ID of this o auth connection.
	 *
	 * @param userId the user ID of this o auth connection
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this o auth connection.
	 *
	 * @param userUuid the user uuid of this o auth connection
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected OAuthConnectionWrapper wrap(OAuthConnection oAuthConnection) {
		return new OAuthConnectionWrapper(oAuthConnection);
	}

}
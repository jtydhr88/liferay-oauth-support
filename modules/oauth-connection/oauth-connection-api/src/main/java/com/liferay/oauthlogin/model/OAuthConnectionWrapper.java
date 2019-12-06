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

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
	implements OAuthConnection, ModelWrapper<OAuthConnection> {

	public OAuthConnectionWrapper(OAuthConnection oAuthConnection) {
		_oAuthConnection = oAuthConnection;
	}

	@Override
	public Class<?> getModelClass() {
		return OAuthConnection.class;
	}

	@Override
	public String getModelClassName() {
		return OAuthConnection.class.getName();
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

	@Override
	public Object clone() {
		return new OAuthConnectionWrapper(
			(OAuthConnection)_oAuthConnection.clone());
	}

	@Override
	public int compareTo(OAuthConnection oAuthConnection) {
		return _oAuthConnection.compareTo(oAuthConnection);
	}

	/**
	 * Returns the access token extractor type of this o auth connection.
	 *
	 * @return the access token extractor type of this o auth connection
	 */
	@Override
	public int getAccessTokenExtractorType() {
		return _oAuthConnection.getAccessTokenExtractorType();
	}

	/**
	 * Returns the access token url of this o auth connection.
	 *
	 * @return the access token url of this o auth connection
	 */
	@Override
	public String getAccessTokenURL() {
		return _oAuthConnection.getAccessTokenURL();
	}

	/**
	 * Returns the access token verb of this o auth connection.
	 *
	 * @return the access token verb of this o auth connection
	 */
	@Override
	public int getAccessTokenVerb() {
		return _oAuthConnection.getAccessTokenVerb();
	}

	/**
	 * Returns the authorize url of this o auth connection.
	 *
	 * @return the authorize url of this o auth connection
	 */
	@Override
	public String getAuthorizeURL() {
		return _oAuthConnection.getAuthorizeURL();
	}

	/**
	 * Returns the company ID of this o auth connection.
	 *
	 * @return the company ID of this o auth connection
	 */
	@Override
	public long getCompanyId() {
		return _oAuthConnection.getCompanyId();
	}

	/**
	 * Returns the create date of this o auth connection.
	 *
	 * @return the create date of this o auth connection
	 */
	@Override
	public Date getCreateDate() {
		return _oAuthConnection.getCreateDate();
	}

	/**
	 * Returns the description of this o auth connection.
	 *
	 * @return the description of this o auth connection
	 */
	@Override
	public String getDescription() {
		return _oAuthConnection.getDescription();
	}

	/**
	 * Returns the enabled of this o auth connection.
	 *
	 * @return the enabled of this o auth connection
	 */
	@Override
	public boolean getEnabled() {
		return _oAuthConnection.getEnabled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _oAuthConnection.getExpandoBridge();
	}

	/**
	 * Returns the icon ID of this o auth connection.
	 *
	 * @return the icon ID of this o auth connection
	 */
	@Override
	public long getIconId() {
		return _oAuthConnection.getIconId();
	}

	/**
	 * Returns the key of this o auth connection.
	 *
	 * @return the key of this o auth connection
	 */
	@Override
	public String getKey() {
		return _oAuthConnection.getKey();
	}

	/**
	 * Returns the modified date of this o auth connection.
	 *
	 * @return the modified date of this o auth connection
	 */
	@Override
	public Date getModifiedDate() {
		return _oAuthConnection.getModifiedDate();
	}

	/**
	 * Returns the name of this o auth connection.
	 *
	 * @return the name of this o auth connection
	 */
	@Override
	public String getName() {
		return _oAuthConnection.getName();
	}

	/**
	 * Returns the o auth connection ID of this o auth connection.
	 *
	 * @return the o auth connection ID of this o auth connection
	 */
	@Override
	public long getOAuthConnectionId() {
		return _oAuthConnection.getOAuthConnectionId();
	}

	/**
	 * Returns the o auth version of this o auth connection.
	 *
	 * @return the o auth version of this o auth connection
	 */
	@Override
	public int getOAuthVersion() {
		return _oAuthConnection.getOAuthVersion();
	}

	/**
	 * Returns the primary key of this o auth connection.
	 *
	 * @return the primary key of this o auth connection
	 */
	@Override
	public long getPrimaryKey() {
		return _oAuthConnection.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _oAuthConnection.getPrimaryKeyObj();
	}

	/**
	 * Returns the redirect url of this o auth connection.
	 *
	 * @return the redirect url of this o auth connection
	 */
	@Override
	public String getRedirectURL() {
		return _oAuthConnection.getRedirectURL();
	}

	/**
	 * Returns the request token url of this o auth connection.
	 *
	 * @return the request token url of this o auth connection
	 */
	@Override
	public String getRequestTokenURL() {
		return _oAuthConnection.getRequestTokenURL();
	}

	/**
	 * Returns the request token verb of this o auth connection.
	 *
	 * @return the request token verb of this o auth connection
	 */
	@Override
	public int getRequestTokenVerb() {
		return _oAuthConnection.getRequestTokenVerb();
	}

	/**
	 * Returns the scope of this o auth connection.
	 *
	 * @return the scope of this o auth connection
	 */
	@Override
	public String getScope() {
		return _oAuthConnection.getScope();
	}

	/**
	 * Returns the secret of this o auth connection.
	 *
	 * @return the secret of this o auth connection
	 */
	@Override
	public String getSecret() {
		return _oAuthConnection.getSecret();
	}

	/**
	 * Returns the signature service type of this o auth connection.
	 *
	 * @return the signature service type of this o auth connection
	 */
	@Override
	public int getSignatureServiceType() {
		return _oAuthConnection.getSignatureServiceType();
	}

	/**
	 * Returns the social account ID field of this o auth connection.
	 *
	 * @return the social account ID field of this o auth connection
	 */
	@Override
	public String getSocialAccountIdField() {
		return _oAuthConnection.getSocialAccountIdField();
	}

	/**
	 * Returns the social account ID script of this o auth connection.
	 *
	 * @return the social account ID script of this o auth connection
	 */
	@Override
	public String getSocialAccountIdScript() {
		return _oAuthConnection.getSocialAccountIdScript();
	}

	/**
	 * Returns the social account ID type of this o auth connection.
	 *
	 * @return the social account ID type of this o auth connection
	 */
	@Override
	public int getSocialAccountIdType() {
		return _oAuthConnection.getSocialAccountIdType();
	}

	/**
	 * Returns the social account ID url of this o auth connection.
	 *
	 * @return the social account ID url of this o auth connection
	 */
	@Override
	public String getSocialAccountIdURL() {
		return _oAuthConnection.getSocialAccountIdURL();
	}

	/**
	 * Returns the social account ID url verb of this o auth connection.
	 *
	 * @return the social account ID url verb of this o auth connection
	 */
	@Override
	public int getSocialAccountIdURLVerb() {
		return _oAuthConnection.getSocialAccountIdURLVerb();
	}

	/**
	 * Returns the user ID of this o auth connection.
	 *
	 * @return the user ID of this o auth connection
	 */
	@Override
	public long getUserId() {
		return _oAuthConnection.getUserId();
	}

	/**
	 * Returns the user uuid of this o auth connection.
	 *
	 * @return the user uuid of this o auth connection
	 */
	@Override
	public String getUserUuid() {
		return _oAuthConnection.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _oAuthConnection.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _oAuthConnection.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this o auth connection is enabled.
	 *
	 * @return <code>true</code> if this o auth connection is enabled; <code>false</code> otherwise
	 */
	@Override
	public boolean isEnabled() {
		return _oAuthConnection.isEnabled();
	}

	@Override
	public boolean isEscapedModel() {
		return _oAuthConnection.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _oAuthConnection.isNew();
	}

	@Override
	public void persist() {
		_oAuthConnection.persist();
	}

	/**
	 * Sets the access token extractor type of this o auth connection.
	 *
	 * @param accessTokenExtractorType the access token extractor type of this o auth connection
	 */
	@Override
	public void setAccessTokenExtractorType(int accessTokenExtractorType) {
		_oAuthConnection.setAccessTokenExtractorType(accessTokenExtractorType);
	}

	/**
	 * Sets the access token url of this o auth connection.
	 *
	 * @param accessTokenURL the access token url of this o auth connection
	 */
	@Override
	public void setAccessTokenURL(String accessTokenURL) {
		_oAuthConnection.setAccessTokenURL(accessTokenURL);
	}

	/**
	 * Sets the access token verb of this o auth connection.
	 *
	 * @param accessTokenVerb the access token verb of this o auth connection
	 */
	@Override
	public void setAccessTokenVerb(int accessTokenVerb) {
		_oAuthConnection.setAccessTokenVerb(accessTokenVerb);
	}

	/**
	 * Sets the authorize url of this o auth connection.
	 *
	 * @param authorizeURL the authorize url of this o auth connection
	 */
	@Override
	public void setAuthorizeURL(String authorizeURL) {
		_oAuthConnection.setAuthorizeURL(authorizeURL);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_oAuthConnection.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this o auth connection.
	 *
	 * @param companyId the company ID of this o auth connection
	 */
	@Override
	public void setCompanyId(long companyId) {
		_oAuthConnection.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this o auth connection.
	 *
	 * @param createDate the create date of this o auth connection
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_oAuthConnection.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this o auth connection.
	 *
	 * @param description the description of this o auth connection
	 */
	@Override
	public void setDescription(String description) {
		_oAuthConnection.setDescription(description);
	}

	/**
	 * Sets whether this o auth connection is enabled.
	 *
	 * @param enabled the enabled of this o auth connection
	 */
	@Override
	public void setEnabled(boolean enabled) {
		_oAuthConnection.setEnabled(enabled);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_oAuthConnection.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_oAuthConnection.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_oAuthConnection.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the icon ID of this o auth connection.
	 *
	 * @param iconId the icon ID of this o auth connection
	 */
	@Override
	public void setIconId(long iconId) {
		_oAuthConnection.setIconId(iconId);
	}

	/**
	 * Sets the key of this o auth connection.
	 *
	 * @param key the key of this o auth connection
	 */
	@Override
	public void setKey(String key) {
		_oAuthConnection.setKey(key);
	}

	/**
	 * Sets the modified date of this o auth connection.
	 *
	 * @param modifiedDate the modified date of this o auth connection
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_oAuthConnection.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this o auth connection.
	 *
	 * @param name the name of this o auth connection
	 */
	@Override
	public void setName(String name) {
		_oAuthConnection.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_oAuthConnection.setNew(n);
	}

	/**
	 * Sets the o auth connection ID of this o auth connection.
	 *
	 * @param oAuthConnectionId the o auth connection ID of this o auth connection
	 */
	@Override
	public void setOAuthConnectionId(long oAuthConnectionId) {
		_oAuthConnection.setOAuthConnectionId(oAuthConnectionId);
	}

	/**
	 * Sets the o auth version of this o auth connection.
	 *
	 * @param oAuthVersion the o auth version of this o auth connection
	 */
	@Override
	public void setOAuthVersion(int oAuthVersion) {
		_oAuthConnection.setOAuthVersion(oAuthVersion);
	}

	/**
	 * Sets the primary key of this o auth connection.
	 *
	 * @param primaryKey the primary key of this o auth connection
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_oAuthConnection.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_oAuthConnection.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the redirect url of this o auth connection.
	 *
	 * @param redirectURL the redirect url of this o auth connection
	 */
	@Override
	public void setRedirectURL(String redirectURL) {
		_oAuthConnection.setRedirectURL(redirectURL);
	}

	/**
	 * Sets the request token url of this o auth connection.
	 *
	 * @param requestTokenURL the request token url of this o auth connection
	 */
	@Override
	public void setRequestTokenURL(String requestTokenURL) {
		_oAuthConnection.setRequestTokenURL(requestTokenURL);
	}

	/**
	 * Sets the request token verb of this o auth connection.
	 *
	 * @param requestTokenVerb the request token verb of this o auth connection
	 */
	@Override
	public void setRequestTokenVerb(int requestTokenVerb) {
		_oAuthConnection.setRequestTokenVerb(requestTokenVerb);
	}

	/**
	 * Sets the scope of this o auth connection.
	 *
	 * @param scope the scope of this o auth connection
	 */
	@Override
	public void setScope(String scope) {
		_oAuthConnection.setScope(scope);
	}

	/**
	 * Sets the secret of this o auth connection.
	 *
	 * @param secret the secret of this o auth connection
	 */
	@Override
	public void setSecret(String secret) {
		_oAuthConnection.setSecret(secret);
	}

	/**
	 * Sets the signature service type of this o auth connection.
	 *
	 * @param signatureServiceType the signature service type of this o auth connection
	 */
	@Override
	public void setSignatureServiceType(int signatureServiceType) {
		_oAuthConnection.setSignatureServiceType(signatureServiceType);
	}

	/**
	 * Sets the social account ID field of this o auth connection.
	 *
	 * @param socialAccountIdField the social account ID field of this o auth connection
	 */
	@Override
	public void setSocialAccountIdField(String socialAccountIdField) {
		_oAuthConnection.setSocialAccountIdField(socialAccountIdField);
	}

	/**
	 * Sets the social account ID script of this o auth connection.
	 *
	 * @param socialAccountIdScript the social account ID script of this o auth connection
	 */
	@Override
	public void setSocialAccountIdScript(String socialAccountIdScript) {
		_oAuthConnection.setSocialAccountIdScript(socialAccountIdScript);
	}

	/**
	 * Sets the social account ID type of this o auth connection.
	 *
	 * @param socialAccountIdType the social account ID type of this o auth connection
	 */
	@Override
	public void setSocialAccountIdType(int socialAccountIdType) {
		_oAuthConnection.setSocialAccountIdType(socialAccountIdType);
	}

	/**
	 * Sets the social account ID url of this o auth connection.
	 *
	 * @param socialAccountIdURL the social account ID url of this o auth connection
	 */
	@Override
	public void setSocialAccountIdURL(String socialAccountIdURL) {
		_oAuthConnection.setSocialAccountIdURL(socialAccountIdURL);
	}

	/**
	 * Sets the social account ID url verb of this o auth connection.
	 *
	 * @param socialAccountIdURLVerb the social account ID url verb of this o auth connection
	 */
	@Override
	public void setSocialAccountIdURLVerb(int socialAccountIdURLVerb) {
		_oAuthConnection.setSocialAccountIdURLVerb(socialAccountIdURLVerb);
	}

	/**
	 * Sets the user ID of this o auth connection.
	 *
	 * @param userId the user ID of this o auth connection
	 */
	@Override
	public void setUserId(long userId) {
		_oAuthConnection.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this o auth connection.
	 *
	 * @param userUuid the user uuid of this o auth connection
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_oAuthConnection.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<OAuthConnection>
		toCacheModel() {

		return _oAuthConnection.toCacheModel();
	}

	@Override
	public OAuthConnection toEscapedModel() {
		return new OAuthConnectionWrapper(_oAuthConnection.toEscapedModel());
	}

	@Override
	public String toString() {
		return _oAuthConnection.toString();
	}

	@Override
	public OAuthConnection toUnescapedModel() {
		return new OAuthConnectionWrapper(_oAuthConnection.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _oAuthConnection.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OAuthConnectionWrapper)) {
			return false;
		}

		OAuthConnectionWrapper oAuthConnectionWrapper =
			(OAuthConnectionWrapper)obj;

		if (Objects.equals(
				_oAuthConnection, oAuthConnectionWrapper._oAuthConnection)) {

			return true;
		}

		return false;
	}

	@Override
	public OAuthConnection getWrappedModel() {
		return _oAuthConnection;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _oAuthConnection.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _oAuthConnection.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_oAuthConnection.resetOriginalValues();
	}

	private final OAuthConnection _oAuthConnection;

}
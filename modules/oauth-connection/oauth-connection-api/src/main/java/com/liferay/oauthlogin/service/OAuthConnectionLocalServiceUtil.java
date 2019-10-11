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

package com.liferay.oauthlogin.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for OAuthConnection. This utility wraps
 * <code>com.liferay.oauthlogin.service.impl.OAuthConnectionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see OAuthConnectionLocalService
 * @generated
 */
@ProviderType
public class OAuthConnectionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.oauthlogin.service.impl.OAuthConnectionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.oauthlogin.model.OAuthConnection
			addOAuthConnection(
				boolean enabled, String name, String description,
				int oAuthVersion, String key, String secret, String scope,
				String authorizeURL, String accessTokenURL, int accessTokenVerb,
				int accessTokenExtractorType, String requestTokenURL,
				int requestTokenVerb, int signatureServiceType,
				String redirectURL, String socialAccountIdURL,
				int socialAccountIdURLVerb, String socialAccountIdField,
				int socialAccountIdType, String socialAccountIdScript,
				java.io.File icon,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().addOAuthConnection(
			enabled, name, description, oAuthVersion, key, secret, scope,
			authorizeURL, accessTokenURL, accessTokenVerb,
			accessTokenExtractorType, requestTokenURL, requestTokenVerb,
			signatureServiceType, redirectURL, socialAccountIdURL,
			socialAccountIdURLVerb, socialAccountIdField, socialAccountIdType,
			socialAccountIdScript, icon, serviceContext);
	}

	/**
	 * Adds the o auth connection to the database. Also notifies the appropriate model listeners.
	 *
	 * @param oAuthConnection the o auth connection
	 * @return the o auth connection that was added
	 */
	public static com.liferay.oauthlogin.model.OAuthConnection
		addOAuthConnection(
			com.liferay.oauthlogin.model.OAuthConnection oAuthConnection) {

		return getService().addOAuthConnection(oAuthConnection);
	}

	/**
	 * Creates a new o auth connection with the primary key. Does not add the o auth connection to the database.
	 *
	 * @param oAuthConnectionId the primary key for the new o auth connection
	 * @return the new o auth connection
	 */
	public static com.liferay.oauthlogin.model.OAuthConnection
		createOAuthConnection(long oAuthConnectionId) {

		return getService().createOAuthConnection(oAuthConnectionId);
	}

	/**
	 * Deletes the o auth connection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oAuthConnectionId the primary key of the o auth connection
	 * @return the o auth connection that was removed
	 * @throws PortalException if a o auth connection with the primary key could not be found
	 * @throws SystemException
	 */
	public static com.liferay.oauthlogin.model.OAuthConnection
			deleteOAuthConnection(long oAuthConnectionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().deleteOAuthConnection(oAuthConnectionId);
	}

	/**
	 * Deletes the o auth connection from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oAuthConnection the o auth connection
	 * @return the o auth connection that was removed
	 */
	public static com.liferay.oauthlogin.model.OAuthConnection
		deleteOAuthConnection(
			com.liferay.oauthlogin.model.OAuthConnection oAuthConnection) {

		return getService().deleteOAuthConnection(oAuthConnection);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.oauthlogin.model.impl.OAuthConnectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.oauthlogin.model.impl.OAuthConnectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.oauthlogin.model.OAuthConnection
		fetchOAuthConnection(long oAuthConnectionId) {

		return getService().fetchOAuthConnection(oAuthConnectionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the o auth connection with the primary key.
	 *
	 * @param oAuthConnectionId the primary key of the o auth connection
	 * @return the o auth connection
	 * @throws PortalException if a o auth connection with the primary key could not be found
	 */
	public static com.liferay.oauthlogin.model.OAuthConnection
			getOAuthConnection(long oAuthConnectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getOAuthConnection(oAuthConnectionId);
	}

	/**
	 * Returns a range of all the o auth connections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.oauthlogin.model.impl.OAuthConnectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of o auth connections
	 * @param end the upper bound of the range of o auth connections (not inclusive)
	 * @return the range of o auth connections
	 */
	public static java.util.List<com.liferay.oauthlogin.model.OAuthConnection>
		getOAuthConnections(int start, int end) {

		return getService().getOAuthConnections(start, end);
	}

	/**
	 * Returns the number of o auth connections.
	 *
	 * @return the number of o auth connections
	 */
	public static int getOAuthConnectionsCount() {
		return getService().getOAuthConnectionsCount();
	}

	public static java.util.List<com.liferay.oauthlogin.model.OAuthConnection>
			getOAuthConnectionsEnabled(boolean enabled)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getOAuthConnectionsEnabled(enabled);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.liferay.oauthlogin.model.OAuthConnection
			updateOAuthConnection(
				long oAuthConnectionId, boolean enabled, String name,
				String description, int oAuthVersion, String key, String secret,
				String scope, String authorizeURL, String accessTokenURL,
				int accessTokenVerb, int accessTokenExtractorType,
				String requestTokenURL, int requestTokenVerb,
				int signatureServiceType, String redirectURL,
				String socialAccountIdURL, int socialAccountIdURLVerb,
				String socialAccountIdField, int socialAccountIdType,
				String socialAccountIdScript, java.io.File icon,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().updateOAuthConnection(
			oAuthConnectionId, enabled, name, description, oAuthVersion, key,
			secret, scope, authorizeURL, accessTokenURL, accessTokenVerb,
			accessTokenExtractorType, requestTokenURL, requestTokenVerb,
			signatureServiceType, redirectURL, socialAccountIdURL,
			socialAccountIdURLVerb, socialAccountIdField, socialAccountIdType,
			socialAccountIdScript, icon, serviceContext);
	}

	/**
	 * Updates the o auth connection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param oAuthConnection the o auth connection
	 * @return the o auth connection that was updated
	 */
	public static com.liferay.oauthlogin.model.OAuthConnection
		updateOAuthConnection(
			com.liferay.oauthlogin.model.OAuthConnection oAuthConnection) {

		return getService().updateOAuthConnection(oAuthConnection);
	}

	public static OAuthConnectionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OAuthConnectionLocalService, OAuthConnectionLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			OAuthConnectionLocalService.class);

		ServiceTracker<OAuthConnectionLocalService, OAuthConnectionLocalService>
			serviceTracker =
				new ServiceTracker
					<OAuthConnectionLocalService, OAuthConnectionLocalService>(
						bundle.getBundleContext(),
						OAuthConnectionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
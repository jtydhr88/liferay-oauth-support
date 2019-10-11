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

package com.liferay.oauthlogin.service.persistence;

import com.liferay.oauthlogin.model.OAuthConnection;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the o auth connection service. This utility wraps <code>com.liferay.oauthlogin.service.persistence.impl.OAuthConnectionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OAuthConnectionPersistence
 * @generated
 */
@ProviderType
public class OAuthConnectionUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(OAuthConnection oAuthConnection) {
		getPersistence().clearCache(oAuthConnection);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, OAuthConnection> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OAuthConnection> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OAuthConnection> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OAuthConnection> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OAuthConnection> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static OAuthConnection update(OAuthConnection oAuthConnection) {
		return getPersistence().update(oAuthConnection);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static OAuthConnection update(
		OAuthConnection oAuthConnection, ServiceContext serviceContext) {

		return getPersistence().update(oAuthConnection, serviceContext);
	}

	/**
	 * Returns all the o auth connections where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @return the matching o auth connections
	 */
	public static List<OAuthConnection> findByEnabled(boolean enabled) {
		return getPersistence().findByEnabled(enabled);
	}

	/**
	 * Returns a range of all the o auth connections where enabled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OAuthConnectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param enabled the enabled
	 * @param start the lower bound of the range of o auth connections
	 * @param end the upper bound of the range of o auth connections (not inclusive)
	 * @return the range of matching o auth connections
	 */
	public static List<OAuthConnection> findByEnabled(
		boolean enabled, int start, int end) {

		return getPersistence().findByEnabled(enabled, start, end);
	}

	/**
	 * Returns an ordered range of all the o auth connections where enabled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OAuthConnectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByEnabled(boolean, int, int, OrderByComparator)}
	 * @param enabled the enabled
	 * @param start the lower bound of the range of o auth connections
	 * @param end the upper bound of the range of o auth connections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching o auth connections
	 */
	@Deprecated
	public static List<OAuthConnection> findByEnabled(
		boolean enabled, int start, int end,
		OrderByComparator<OAuthConnection> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEnabled(
			enabled, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the o auth connections where enabled = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OAuthConnectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param enabled the enabled
	 * @param start the lower bound of the range of o auth connections
	 * @param end the upper bound of the range of o auth connections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching o auth connections
	 */
	public static List<OAuthConnection> findByEnabled(
		boolean enabled, int start, int end,
		OrderByComparator<OAuthConnection> orderByComparator) {

		return getPersistence().findByEnabled(
			enabled, start, end, orderByComparator);
	}

	/**
	 * Returns the first o auth connection in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth connection
	 * @throws NoSuchOAuthConnectionException if a matching o auth connection could not be found
	 */
	public static OAuthConnection findByEnabled_First(
			boolean enabled,
			OrderByComparator<OAuthConnection> orderByComparator)
		throws com.liferay.oauthlogin.exception.NoSuchOAuthConnectionException {

		return getPersistence().findByEnabled_First(enabled, orderByComparator);
	}

	/**
	 * Returns the first o auth connection in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth connection, or <code>null</code> if a matching o auth connection could not be found
	 */
	public static OAuthConnection fetchByEnabled_First(
		boolean enabled, OrderByComparator<OAuthConnection> orderByComparator) {

		return getPersistence().fetchByEnabled_First(
			enabled, orderByComparator);
	}

	/**
	 * Returns the last o auth connection in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o auth connection
	 * @throws NoSuchOAuthConnectionException if a matching o auth connection could not be found
	 */
	public static OAuthConnection findByEnabled_Last(
			boolean enabled,
			OrderByComparator<OAuthConnection> orderByComparator)
		throws com.liferay.oauthlogin.exception.NoSuchOAuthConnectionException {

		return getPersistence().findByEnabled_Last(enabled, orderByComparator);
	}

	/**
	 * Returns the last o auth connection in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o auth connection, or <code>null</code> if a matching o auth connection could not be found
	 */
	public static OAuthConnection fetchByEnabled_Last(
		boolean enabled, OrderByComparator<OAuthConnection> orderByComparator) {

		return getPersistence().fetchByEnabled_Last(enabled, orderByComparator);
	}

	/**
	 * Returns the o auth connections before and after the current o auth connection in the ordered set where enabled = &#63;.
	 *
	 * @param oAuthConnectionId the primary key of the current o auth connection
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next o auth connection
	 * @throws NoSuchOAuthConnectionException if a o auth connection with the primary key could not be found
	 */
	public static OAuthConnection[] findByEnabled_PrevAndNext(
			long oAuthConnectionId, boolean enabled,
			OrderByComparator<OAuthConnection> orderByComparator)
		throws com.liferay.oauthlogin.exception.NoSuchOAuthConnectionException {

		return getPersistence().findByEnabled_PrevAndNext(
			oAuthConnectionId, enabled, orderByComparator);
	}

	/**
	 * Removes all the o auth connections where enabled = &#63; from the database.
	 *
	 * @param enabled the enabled
	 */
	public static void removeByEnabled(boolean enabled) {
		getPersistence().removeByEnabled(enabled);
	}

	/**
	 * Returns the number of o auth connections where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @return the number of matching o auth connections
	 */
	public static int countByEnabled(boolean enabled) {
		return getPersistence().countByEnabled(enabled);
	}

	/**
	 * Caches the o auth connection in the entity cache if it is enabled.
	 *
	 * @param oAuthConnection the o auth connection
	 */
	public static void cacheResult(OAuthConnection oAuthConnection) {
		getPersistence().cacheResult(oAuthConnection);
	}

	/**
	 * Caches the o auth connections in the entity cache if it is enabled.
	 *
	 * @param oAuthConnections the o auth connections
	 */
	public static void cacheResult(List<OAuthConnection> oAuthConnections) {
		getPersistence().cacheResult(oAuthConnections);
	}

	/**
	 * Creates a new o auth connection with the primary key. Does not add the o auth connection to the database.
	 *
	 * @param oAuthConnectionId the primary key for the new o auth connection
	 * @return the new o auth connection
	 */
	public static OAuthConnection create(long oAuthConnectionId) {
		return getPersistence().create(oAuthConnectionId);
	}

	/**
	 * Removes the o auth connection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oAuthConnectionId the primary key of the o auth connection
	 * @return the o auth connection that was removed
	 * @throws NoSuchOAuthConnectionException if a o auth connection with the primary key could not be found
	 */
	public static OAuthConnection remove(long oAuthConnectionId)
		throws com.liferay.oauthlogin.exception.NoSuchOAuthConnectionException {

		return getPersistence().remove(oAuthConnectionId);
	}

	public static OAuthConnection updateImpl(OAuthConnection oAuthConnection) {
		return getPersistence().updateImpl(oAuthConnection);
	}

	/**
	 * Returns the o auth connection with the primary key or throws a <code>NoSuchOAuthConnectionException</code> if it could not be found.
	 *
	 * @param oAuthConnectionId the primary key of the o auth connection
	 * @return the o auth connection
	 * @throws NoSuchOAuthConnectionException if a o auth connection with the primary key could not be found
	 */
	public static OAuthConnection findByPrimaryKey(long oAuthConnectionId)
		throws com.liferay.oauthlogin.exception.NoSuchOAuthConnectionException {

		return getPersistence().findByPrimaryKey(oAuthConnectionId);
	}

	/**
	 * Returns the o auth connection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oAuthConnectionId the primary key of the o auth connection
	 * @return the o auth connection, or <code>null</code> if a o auth connection with the primary key could not be found
	 */
	public static OAuthConnection fetchByPrimaryKey(long oAuthConnectionId) {
		return getPersistence().fetchByPrimaryKey(oAuthConnectionId);
	}

	/**
	 * Returns all the o auth connections.
	 *
	 * @return the o auth connections
	 */
	public static List<OAuthConnection> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the o auth connections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OAuthConnectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of o auth connections
	 * @param end the upper bound of the range of o auth connections (not inclusive)
	 * @return the range of o auth connections
	 */
	public static List<OAuthConnection> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the o auth connections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OAuthConnectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of o auth connections
	 * @param end the upper bound of the range of o auth connections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of o auth connections
	 */
	@Deprecated
	public static List<OAuthConnection> findAll(
		int start, int end,
		OrderByComparator<OAuthConnection> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the o auth connections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>OAuthConnectionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of o auth connections
	 * @param end the upper bound of the range of o auth connections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of o auth connections
	 */
	public static List<OAuthConnection> findAll(
		int start, int end,
		OrderByComparator<OAuthConnection> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the o auth connections from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of o auth connections.
	 *
	 * @return the number of o auth connections
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OAuthConnectionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<OAuthConnectionPersistence, OAuthConnectionPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			OAuthConnectionPersistence.class);

		ServiceTracker<OAuthConnectionPersistence, OAuthConnectionPersistence>
			serviceTracker =
				new ServiceTracker
					<OAuthConnectionPersistence, OAuthConnectionPersistence>(
						bundle.getBundleContext(),
						OAuthConnectionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
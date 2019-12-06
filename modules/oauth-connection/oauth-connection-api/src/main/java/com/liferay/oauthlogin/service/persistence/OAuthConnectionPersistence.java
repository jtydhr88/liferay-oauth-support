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

import aQute.bnd.annotation.ProviderType;

import com.liferay.oauthlogin.exception.NoSuchOAuthConnectionException;
import com.liferay.oauthlogin.model.OAuthConnection;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the o auth connection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OAuthConnectionUtil
 * @generated
 */
@ProviderType
public interface OAuthConnectionPersistence
	extends BasePersistence<OAuthConnection> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OAuthConnectionUtil} to access the o auth connection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, OAuthConnection> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the o auth connections where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @return the matching o auth connections
	 */
	public java.util.List<OAuthConnection> findByEnabled(boolean enabled);

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
	public java.util.List<OAuthConnection> findByEnabled(
		boolean enabled, int start, int end);

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
	public java.util.List<OAuthConnection> findByEnabled(
		boolean enabled, int start, int end,
		OrderByComparator<OAuthConnection> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<OAuthConnection> findByEnabled(
		boolean enabled, int start, int end,
		OrderByComparator<OAuthConnection> orderByComparator);

	/**
	 * Returns the first o auth connection in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth connection
	 * @throws NoSuchOAuthConnectionException if a matching o auth connection could not be found
	 */
	public OAuthConnection findByEnabled_First(
			boolean enabled,
			OrderByComparator<OAuthConnection> orderByComparator)
		throws NoSuchOAuthConnectionException;

	/**
	 * Returns the first o auth connection in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth connection, or <code>null</code> if a matching o auth connection could not be found
	 */
	public OAuthConnection fetchByEnabled_First(
		boolean enabled, OrderByComparator<OAuthConnection> orderByComparator);

	/**
	 * Returns the last o auth connection in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o auth connection
	 * @throws NoSuchOAuthConnectionException if a matching o auth connection could not be found
	 */
	public OAuthConnection findByEnabled_Last(
			boolean enabled,
			OrderByComparator<OAuthConnection> orderByComparator)
		throws NoSuchOAuthConnectionException;

	/**
	 * Returns the last o auth connection in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o auth connection, or <code>null</code> if a matching o auth connection could not be found
	 */
	public OAuthConnection fetchByEnabled_Last(
		boolean enabled, OrderByComparator<OAuthConnection> orderByComparator);

	/**
	 * Returns the o auth connections before and after the current o auth connection in the ordered set where enabled = &#63;.
	 *
	 * @param oAuthConnectionId the primary key of the current o auth connection
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next o auth connection
	 * @throws NoSuchOAuthConnectionException if a o auth connection with the primary key could not be found
	 */
	public OAuthConnection[] findByEnabled_PrevAndNext(
			long oAuthConnectionId, boolean enabled,
			OrderByComparator<OAuthConnection> orderByComparator)
		throws NoSuchOAuthConnectionException;

	/**
	 * Removes all the o auth connections where enabled = &#63; from the database.
	 *
	 * @param enabled the enabled
	 */
	public void removeByEnabled(boolean enabled);

	/**
	 * Returns the number of o auth connections where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @return the number of matching o auth connections
	 */
	public int countByEnabled(boolean enabled);

	/**
	 * Caches the o auth connection in the entity cache if it is enabled.
	 *
	 * @param oAuthConnection the o auth connection
	 */
	public void cacheResult(OAuthConnection oAuthConnection);

	/**
	 * Caches the o auth connections in the entity cache if it is enabled.
	 *
	 * @param oAuthConnections the o auth connections
	 */
	public void cacheResult(java.util.List<OAuthConnection> oAuthConnections);

	/**
	 * Creates a new o auth connection with the primary key. Does not add the o auth connection to the database.
	 *
	 * @param oAuthConnectionId the primary key for the new o auth connection
	 * @return the new o auth connection
	 */
	public OAuthConnection create(long oAuthConnectionId);

	/**
	 * Removes the o auth connection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oAuthConnectionId the primary key of the o auth connection
	 * @return the o auth connection that was removed
	 * @throws NoSuchOAuthConnectionException if a o auth connection with the primary key could not be found
	 */
	public OAuthConnection remove(long oAuthConnectionId)
		throws NoSuchOAuthConnectionException;

	public OAuthConnection updateImpl(OAuthConnection oAuthConnection);

	/**
	 * Returns the o auth connection with the primary key or throws a <code>NoSuchOAuthConnectionException</code> if it could not be found.
	 *
	 * @param oAuthConnectionId the primary key of the o auth connection
	 * @return the o auth connection
	 * @throws NoSuchOAuthConnectionException if a o auth connection with the primary key could not be found
	 */
	public OAuthConnection findByPrimaryKey(long oAuthConnectionId)
		throws NoSuchOAuthConnectionException;

	/**
	 * Returns the o auth connection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oAuthConnectionId the primary key of the o auth connection
	 * @return the o auth connection, or <code>null</code> if a o auth connection with the primary key could not be found
	 */
	public OAuthConnection fetchByPrimaryKey(long oAuthConnectionId);

	/**
	 * Returns all the o auth connections.
	 *
	 * @return the o auth connections
	 */
	public java.util.List<OAuthConnection> findAll();

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
	public java.util.List<OAuthConnection> findAll(int start, int end);

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
	public java.util.List<OAuthConnection> findAll(
		int start, int end,
		OrderByComparator<OAuthConnection> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<OAuthConnection> findAll(
		int start, int end,
		OrderByComparator<OAuthConnection> orderByComparator);

	/**
	 * Removes all the o auth connections from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of o auth connections.
	 *
	 * @return the number of o auth connections
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}
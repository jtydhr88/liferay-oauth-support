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

package com.liferay.oauthlogin.service.persistence.impl;

import com.liferay.oauthlogin.exception.NoSuchOAuthConnectionException;
import com.liferay.oauthlogin.model.OAuthConnection;
import com.liferay.oauthlogin.model.impl.OAuthConnectionImpl;
import com.liferay.oauthlogin.model.impl.OAuthConnectionModelImpl;
import com.liferay.oauthlogin.service.persistence.OAuthConnectionPersistence;
import com.liferay.oauthlogin.service.persistence.impl.constants.OAuthLoginPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the o auth connection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OAuthConnectionPersistence.class)
@ProviderType
public class OAuthConnectionPersistenceImpl
	extends BasePersistenceImpl<OAuthConnection>
	implements OAuthConnectionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OAuthConnectionUtil</code> to access the o auth connection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OAuthConnectionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByEnabled;
	private FinderPath _finderPathWithoutPaginationFindByEnabled;
	private FinderPath _finderPathCountByEnabled;

	/**
	 * Returns all the o auth connections where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @return the matching o auth connections
	 */
	@Override
	public List<OAuthConnection> findByEnabled(boolean enabled) {
		return findByEnabled(
			enabled, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<OAuthConnection> findByEnabled(
		boolean enabled, int start, int end) {

		return findByEnabled(enabled, start, end, null);
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
	@Override
	public List<OAuthConnection> findByEnabled(
		boolean enabled, int start, int end,
		OrderByComparator<OAuthConnection> orderByComparator,
		boolean useFinderCache) {

		return findByEnabled(enabled, start, end, orderByComparator);
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
	@Override
	public List<OAuthConnection> findByEnabled(
		boolean enabled, int start, int end,
		OrderByComparator<OAuthConnection> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByEnabled;
			finderArgs = new Object[] {enabled};
		}
		else {
			finderPath = _finderPathWithPaginationFindByEnabled;
			finderArgs = new Object[] {enabled, start, end, orderByComparator};
		}

		List<OAuthConnection> list =
			(List<OAuthConnection>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OAuthConnection oAuthConnection : list) {
				if ((enabled != oAuthConnection.isEnabled())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_OAUTHCONNECTION_WHERE);

			query.append(_FINDER_COLUMN_ENABLED_ENABLED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(OAuthConnectionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(enabled);

				if (!pagination) {
					list = (List<OAuthConnection>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<OAuthConnection>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first o auth connection in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth connection
	 * @throws NoSuchOAuthConnectionException if a matching o auth connection could not be found
	 */
	@Override
	public OAuthConnection findByEnabled_First(
			boolean enabled,
			OrderByComparator<OAuthConnection> orderByComparator)
		throws NoSuchOAuthConnectionException {

		OAuthConnection oAuthConnection = fetchByEnabled_First(
			enabled, orderByComparator);

		if (oAuthConnection != null) {
			return oAuthConnection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("enabled=");
		msg.append(enabled);

		msg.append("}");

		throw new NoSuchOAuthConnectionException(msg.toString());
	}

	/**
	 * Returns the first o auth connection in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o auth connection, or <code>null</code> if a matching o auth connection could not be found
	 */
	@Override
	public OAuthConnection fetchByEnabled_First(
		boolean enabled, OrderByComparator<OAuthConnection> orderByComparator) {

		List<OAuthConnection> list = findByEnabled(
			enabled, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last o auth connection in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o auth connection
	 * @throws NoSuchOAuthConnectionException if a matching o auth connection could not be found
	 */
	@Override
	public OAuthConnection findByEnabled_Last(
			boolean enabled,
			OrderByComparator<OAuthConnection> orderByComparator)
		throws NoSuchOAuthConnectionException {

		OAuthConnection oAuthConnection = fetchByEnabled_Last(
			enabled, orderByComparator);

		if (oAuthConnection != null) {
			return oAuthConnection;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("enabled=");
		msg.append(enabled);

		msg.append("}");

		throw new NoSuchOAuthConnectionException(msg.toString());
	}

	/**
	 * Returns the last o auth connection in the ordered set where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o auth connection, or <code>null</code> if a matching o auth connection could not be found
	 */
	@Override
	public OAuthConnection fetchByEnabled_Last(
		boolean enabled, OrderByComparator<OAuthConnection> orderByComparator) {

		int count = countByEnabled(enabled);

		if (count == 0) {
			return null;
		}

		List<OAuthConnection> list = findByEnabled(
			enabled, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public OAuthConnection[] findByEnabled_PrevAndNext(
			long oAuthConnectionId, boolean enabled,
			OrderByComparator<OAuthConnection> orderByComparator)
		throws NoSuchOAuthConnectionException {

		OAuthConnection oAuthConnection = findByPrimaryKey(oAuthConnectionId);

		Session session = null;

		try {
			session = openSession();

			OAuthConnection[] array = new OAuthConnectionImpl[3];

			array[0] = getByEnabled_PrevAndNext(
				session, oAuthConnection, enabled, orderByComparator, true);

			array[1] = oAuthConnection;

			array[2] = getByEnabled_PrevAndNext(
				session, oAuthConnection, enabled, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OAuthConnection getByEnabled_PrevAndNext(
		Session session, OAuthConnection oAuthConnection, boolean enabled,
		OrderByComparator<OAuthConnection> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OAUTHCONNECTION_WHERE);

		query.append(_FINDER_COLUMN_ENABLED_ENABLED_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(OAuthConnectionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(enabled);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						oAuthConnection)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<OAuthConnection> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the o auth connections where enabled = &#63; from the database.
	 *
	 * @param enabled the enabled
	 */
	@Override
	public void removeByEnabled(boolean enabled) {
		for (OAuthConnection oAuthConnection :
				findByEnabled(
					enabled, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(oAuthConnection);
		}
	}

	/**
	 * Returns the number of o auth connections where enabled = &#63;.
	 *
	 * @param enabled the enabled
	 * @return the number of matching o auth connections
	 */
	@Override
	public int countByEnabled(boolean enabled) {
		FinderPath finderPath = _finderPathCountByEnabled;

		Object[] finderArgs = new Object[] {enabled};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OAUTHCONNECTION_WHERE);

			query.append(_FINDER_COLUMN_ENABLED_ENABLED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(enabled);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ENABLED_ENABLED_2 =
		"oAuthConnection.enabled = ?";

	public OAuthConnectionPersistenceImpl() {
		setModelClass(OAuthConnection.class);

		setModelImplClass(OAuthConnectionImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("key", "key_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the o auth connection in the entity cache if it is enabled.
	 *
	 * @param oAuthConnection the o auth connection
	 */
	@Override
	public void cacheResult(OAuthConnection oAuthConnection) {
		entityCache.putResult(
			entityCacheEnabled, OAuthConnectionImpl.class,
			oAuthConnection.getPrimaryKey(), oAuthConnection);

		oAuthConnection.resetOriginalValues();
	}

	/**
	 * Caches the o auth connections in the entity cache if it is enabled.
	 *
	 * @param oAuthConnections the o auth connections
	 */
	@Override
	public void cacheResult(List<OAuthConnection> oAuthConnections) {
		for (OAuthConnection oAuthConnection : oAuthConnections) {
			if (entityCache.getResult(
					entityCacheEnabled, OAuthConnectionImpl.class,
					oAuthConnection.getPrimaryKey()) == null) {

				cacheResult(oAuthConnection);
			}
			else {
				oAuthConnection.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all o auth connections.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OAuthConnectionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the o auth connection.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OAuthConnection oAuthConnection) {
		entityCache.removeResult(
			entityCacheEnabled, OAuthConnectionImpl.class,
			oAuthConnection.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OAuthConnection> oAuthConnections) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OAuthConnection oAuthConnection : oAuthConnections) {
			entityCache.removeResult(
				entityCacheEnabled, OAuthConnectionImpl.class,
				oAuthConnection.getPrimaryKey());
		}
	}

	/**
	 * Creates a new o auth connection with the primary key. Does not add the o auth connection to the database.
	 *
	 * @param oAuthConnectionId the primary key for the new o auth connection
	 * @return the new o auth connection
	 */
	@Override
	public OAuthConnection create(long oAuthConnectionId) {
		OAuthConnection oAuthConnection = new OAuthConnectionImpl();

		oAuthConnection.setNew(true);
		oAuthConnection.setPrimaryKey(oAuthConnectionId);

		oAuthConnection.setCompanyId(CompanyThreadLocal.getCompanyId());

		return oAuthConnection;
	}

	/**
	 * Removes the o auth connection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oAuthConnectionId the primary key of the o auth connection
	 * @return the o auth connection that was removed
	 * @throws NoSuchOAuthConnectionException if a o auth connection with the primary key could not be found
	 */
	@Override
	public OAuthConnection remove(long oAuthConnectionId)
		throws NoSuchOAuthConnectionException {

		return remove((Serializable)oAuthConnectionId);
	}

	/**
	 * Removes the o auth connection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the o auth connection
	 * @return the o auth connection that was removed
	 * @throws NoSuchOAuthConnectionException if a o auth connection with the primary key could not be found
	 */
	@Override
	public OAuthConnection remove(Serializable primaryKey)
		throws NoSuchOAuthConnectionException {

		Session session = null;

		try {
			session = openSession();

			OAuthConnection oAuthConnection = (OAuthConnection)session.get(
				OAuthConnectionImpl.class, primaryKey);

			if (oAuthConnection == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOAuthConnectionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(oAuthConnection);
		}
		catch (NoSuchOAuthConnectionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected OAuthConnection removeImpl(OAuthConnection oAuthConnection) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(oAuthConnection)) {
				oAuthConnection = (OAuthConnection)session.get(
					OAuthConnectionImpl.class,
					oAuthConnection.getPrimaryKeyObj());
			}

			if (oAuthConnection != null) {
				session.delete(oAuthConnection);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (oAuthConnection != null) {
			clearCache(oAuthConnection);
		}

		return oAuthConnection;
	}

	@Override
	public OAuthConnection updateImpl(OAuthConnection oAuthConnection) {
		boolean isNew = oAuthConnection.isNew();

		if (!(oAuthConnection instanceof OAuthConnectionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(oAuthConnection.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					oAuthConnection);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in oAuthConnection proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom OAuthConnection implementation " +
					oAuthConnection.getClass());
		}

		OAuthConnectionModelImpl oAuthConnectionModelImpl =
			(OAuthConnectionModelImpl)oAuthConnection;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (oAuthConnection.getCreateDate() == null)) {
			if (serviceContext == null) {
				oAuthConnection.setCreateDate(now);
			}
			else {
				oAuthConnection.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!oAuthConnectionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				oAuthConnection.setModifiedDate(now);
			}
			else {
				oAuthConnection.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (oAuthConnection.isNew()) {
				session.save(oAuthConnection);

				oAuthConnection.setNew(false);
			}
			else {
				oAuthConnection = (OAuthConnection)session.merge(
					oAuthConnection);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {oAuthConnectionModelImpl.isEnabled()};

			finderCache.removeResult(_finderPathCountByEnabled, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByEnabled, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((oAuthConnectionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByEnabled.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					oAuthConnectionModelImpl.getOriginalEnabled()
				};

				finderCache.removeResult(_finderPathCountByEnabled, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByEnabled, args);

				args = new Object[] {oAuthConnectionModelImpl.isEnabled()};

				finderCache.removeResult(_finderPathCountByEnabled, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByEnabled, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, OAuthConnectionImpl.class,
			oAuthConnection.getPrimaryKey(), oAuthConnection, false);

		oAuthConnection.resetOriginalValues();

		return oAuthConnection;
	}

	/**
	 * Returns the o auth connection with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the o auth connection
	 * @return the o auth connection
	 * @throws NoSuchOAuthConnectionException if a o auth connection with the primary key could not be found
	 */
	@Override
	public OAuthConnection findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOAuthConnectionException {

		OAuthConnection oAuthConnection = fetchByPrimaryKey(primaryKey);

		if (oAuthConnection == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOAuthConnectionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return oAuthConnection;
	}

	/**
	 * Returns the o auth connection with the primary key or throws a <code>NoSuchOAuthConnectionException</code> if it could not be found.
	 *
	 * @param oAuthConnectionId the primary key of the o auth connection
	 * @return the o auth connection
	 * @throws NoSuchOAuthConnectionException if a o auth connection with the primary key could not be found
	 */
	@Override
	public OAuthConnection findByPrimaryKey(long oAuthConnectionId)
		throws NoSuchOAuthConnectionException {

		return findByPrimaryKey((Serializable)oAuthConnectionId);
	}

	/**
	 * Returns the o auth connection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oAuthConnectionId the primary key of the o auth connection
	 * @return the o auth connection, or <code>null</code> if a o auth connection with the primary key could not be found
	 */
	@Override
	public OAuthConnection fetchByPrimaryKey(long oAuthConnectionId) {
		return fetchByPrimaryKey((Serializable)oAuthConnectionId);
	}

	/**
	 * Returns all the o auth connections.
	 *
	 * @return the o auth connections
	 */
	@Override
	public List<OAuthConnection> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<OAuthConnection> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<OAuthConnection> findAll(
		int start, int end,
		OrderByComparator<OAuthConnection> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<OAuthConnection> findAll(
		int start, int end,
		OrderByComparator<OAuthConnection> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<OAuthConnection> list =
			(List<OAuthConnection>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_OAUTHCONNECTION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OAUTHCONNECTION;

				if (pagination) {
					sql = sql.concat(OAuthConnectionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OAuthConnection>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<OAuthConnection>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the o auth connections from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OAuthConnection oAuthConnection : findAll()) {
			remove(oAuthConnection);
		}
	}

	/**
	 * Returns the number of o auth connections.
	 *
	 * @return the number of o auth connections
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_OAUTHCONNECTION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "oAuthConnectionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_OAUTHCONNECTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OAuthConnectionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the o auth connection persistence.
	 */
	@Activate
	public void activate() {
		OAuthConnectionModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		OAuthConnectionModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OAuthConnectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OAuthConnectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByEnabled = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OAuthConnectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEnabled",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByEnabled = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, OAuthConnectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEnabled",
			new String[] {Boolean.class.getName()},
			OAuthConnectionModelImpl.ENABLED_COLUMN_BITMASK |
			OAuthConnectionModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByEnabled = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEnabled",
			new String[] {Boolean.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(OAuthConnectionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = OAuthLoginPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.oauthlogin.model.OAuthConnection"),
			true);
	}

	@Override
	@Reference(
		target = OAuthLoginPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = OAuthLoginPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_OAUTHCONNECTION =
		"SELECT oAuthConnection FROM OAuthConnection oAuthConnection";

	private static final String _SQL_SELECT_OAUTHCONNECTION_WHERE =
		"SELECT oAuthConnection FROM OAuthConnection oAuthConnection WHERE ";

	private static final String _SQL_COUNT_OAUTHCONNECTION =
		"SELECT COUNT(oAuthConnection) FROM OAuthConnection oAuthConnection";

	private static final String _SQL_COUNT_OAUTHCONNECTION_WHERE =
		"SELECT COUNT(oAuthConnection) FROM OAuthConnection oAuthConnection WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "oAuthConnection.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No OAuthConnection exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No OAuthConnection exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OAuthConnectionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"key"});

	static {
		try {
			Class.forName(OAuthLoginPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}
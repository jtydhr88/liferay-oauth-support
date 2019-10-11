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

import com.liferay.oauthlogin.exception.*;
import com.liferay.oauthlogin.model.OAuthConnection;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.File;
import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for OAuthConnection. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see OAuthConnectionLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface OAuthConnectionLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OAuthConnectionLocalServiceUtil} to access the o auth connection local service. Add custom service methods to <code>com.liferay.oauthlogin.service.impl.OAuthConnectionLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public OAuthConnection addOAuthConnection(
			boolean enabled, String name, String description, int oAuthVersion,
			String key, String secret, String scope, String authorizeURL,
			String accessTokenURL, int accessTokenVerb,
			int accessTokenExtractorType, String requestTokenURL,
			int requestTokenVerb, int signatureServiceType, String redirectURL,
			String socialAccountIdURL, int socialAccountIdURLVerb,
			String socialAccountIdField, int socialAccountIdType,
			String socialAccountIdScript, File icon,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

	/**
	 * Adds the o auth connection to the database. Also notifies the appropriate model listeners.
	 *
	 * @param oAuthConnection the o auth connection
	 * @return the o auth connection that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public OAuthConnection addOAuthConnection(OAuthConnection oAuthConnection);

	/**
	 * Creates a new o auth connection with the primary key. Does not add the o auth connection to the database.
	 *
	 * @param oAuthConnectionId the primary key for the new o auth connection
	 * @return the new o auth connection
	 */
	@Transactional(enabled = false)
	public OAuthConnection createOAuthConnection(long oAuthConnectionId);

	/**
	 * Deletes the o auth connection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oAuthConnectionId the primary key of the o auth connection
	 * @return the o auth connection that was removed
	 * @throws PortalException if a o auth connection with the primary key could not be found
	 * @throws SystemException
	 */
	@Indexable(type = IndexableType.DELETE)
	public OAuthConnection deleteOAuthConnection(long oAuthConnectionId)
		throws PortalException, SystemException;

	/**
	 * Deletes the o auth connection from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oAuthConnection the o auth connection
	 * @return the o auth connection that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public OAuthConnection deleteOAuthConnection(
		OAuthConnection oAuthConnection);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OAuthConnection fetchOAuthConnection(long oAuthConnectionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the o auth connection with the primary key.
	 *
	 * @param oAuthConnectionId the primary key of the o auth connection
	 * @return the o auth connection
	 * @throws PortalException if a o auth connection with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OAuthConnection getOAuthConnection(long oAuthConnectionId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OAuthConnection> getOAuthConnections(int start, int end);

	/**
	 * Returns the number of o auth connections.
	 *
	 * @return the number of o auth connections
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOAuthConnectionsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OAuthConnection> getOAuthConnectionsEnabled(boolean enabled)
		throws SystemException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public OAuthConnection updateOAuthConnection(
			long oAuthConnectionId, boolean enabled, String name,
			String description, int oAuthVersion, String key, String secret,
			String scope, String authorizeURL, String accessTokenURL,
			int accessTokenVerb, int accessTokenExtractorType,
			String requestTokenURL, int requestTokenVerb,
			int signatureServiceType, String redirectURL,
			String socialAccountIdURL, int socialAccountIdURLVerb,
			String socialAccountIdField, int socialAccountIdType,
			String socialAccountIdScript, File icon,
			ServiceContext serviceContext)
		throws PortalException, SystemException;

	/**
	 * Updates the o auth connection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param oAuthConnection the o auth connection
	 * @return the o auth connection that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public OAuthConnection updateOAuthConnection(
		OAuthConnection oAuthConnection);

}
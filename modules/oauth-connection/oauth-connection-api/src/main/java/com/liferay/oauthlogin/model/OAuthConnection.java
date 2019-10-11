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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the OAuthConnection service. Represents a row in the &quot;OAuthLogin_OAuthConnection&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see OAuthConnectionModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.oauthlogin.model.impl.OAuthConnectionImpl"
)
@ProviderType
public interface OAuthConnection extends OAuthConnectionModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.oauthlogin.model.impl.OAuthConnectionImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<OAuthConnection, Long>
		O_AUTH_CONNECTION_ID_ACCESSOR = new Accessor<OAuthConnection, Long>() {

			@Override
			public Long get(OAuthConnection oAuthConnection) {
				return oAuthConnection.getOAuthConnectionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<OAuthConnection> getTypeClass() {
				return OAuthConnection.class;
			}

		};

}
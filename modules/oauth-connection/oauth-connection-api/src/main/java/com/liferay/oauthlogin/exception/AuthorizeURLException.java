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
package com.liferay.oauthlogin.exception;

import org.osgi.annotation.versioning.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class AuthorizeURLException extends PortalException {

	public AuthorizeURLException() {
	}

	public AuthorizeURLException(String msg) {
		super(msg);
	}

	public AuthorizeURLException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AuthorizeURLException(Throwable cause) {
		super(cause);
	}

}
package com.liferay.portal.kernel.oauth.terry;

import org.scribe.model.Response;

public class OAuthResponseImpl {
	public OAuthResponseImpl(Response response) {
		_response = response;
	}

	public String getBody() {
		return _response.getBody();
	}

	public int getStatus() {
		return _response.getCode();
	}

	public Object getWrappedOAuthResponse() {
		return _response;
	}

	private Response _response;

}

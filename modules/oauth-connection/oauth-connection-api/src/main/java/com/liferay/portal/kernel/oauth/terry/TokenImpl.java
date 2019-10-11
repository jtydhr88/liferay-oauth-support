package com.liferay.portal.kernel.oauth.terry;

public class TokenImpl {

	public TokenImpl(org.scribe.model.Token token) {
		_token = token;
	}

	public String getRawResponse() {
		return _token.getRawResponse();
	}

	public String getSecret() {
		return _token.getSecret();
	}

	public String getToken() {
		return _token.getToken();
	}

	public Object getWrappedToken() {
		return _token;
	}

	private org.scribe.model.Token _token;

}
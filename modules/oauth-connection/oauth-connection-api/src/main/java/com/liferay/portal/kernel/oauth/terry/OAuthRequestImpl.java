package com.liferay.portal.kernel.oauth.terry;

import com.liferay.portal.kernel.oauth.OAuthException;

public class OAuthRequestImpl {
	public OAuthRequestImpl(org.scribe.model.OAuthRequest oAuthRequest) {
		_oAuthRequest = oAuthRequest;
	}

	public void addBodyParameter(String key, String value) {
		_oAuthRequest.addBodyParameter(key, value);
	}

	public String getURL() {
		return _oAuthRequest.getUrl();
	}

	public Verb getVerb() {
		return VerbTranslator.translate(_oAuthRequest.getVerb());
	}

	public Object getWrappedOAuthRequest() {
		return _oAuthRequest;
	}

	public OAuthResponseImpl send() throws OAuthException {
		try {
			return new OAuthResponseImpl(_oAuthRequest.send());
		}
		catch (Exception e) {
			throw new OAuthException(e);
		}
	}

	private org.scribe.model.OAuthRequest _oAuthRequest;
}

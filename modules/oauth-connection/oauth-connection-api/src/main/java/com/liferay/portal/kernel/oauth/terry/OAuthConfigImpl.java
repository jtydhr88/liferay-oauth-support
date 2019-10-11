package com.liferay.portal.kernel.oauth.terry;

import java.io.OutputStream;

public class OAuthConfigImpl implements OAuthConfig {

	public OAuthConfigImpl(org.scribe.model.OAuthConfig oAuthConfig) {
		_oAuthConfig = oAuthConfig;
	}

	public OAuthConfigImpl(
		String key, String secret, String callbackURL,
		SignatureType signatureType, String scope, OutputStream outputStream) {

		_oAuthConfig = new org.scribe.model.OAuthConfig(
			key, secret, callbackURL,
			SignatureTypeTranslator.translate(signatureType), scope,
			outputStream);
	}

	@Override
	public String getScope() {
		return _oAuthConfig.getScope();
	}

	@Override
	public Object getWrappedOAuthConfig() {
		return _oAuthConfig;
	}

	private org.scribe.model.OAuthConfig _oAuthConfig;

} 

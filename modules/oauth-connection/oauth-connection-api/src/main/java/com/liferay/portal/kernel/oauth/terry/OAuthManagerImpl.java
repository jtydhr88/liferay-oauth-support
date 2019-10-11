package com.liferay.portal.kernel.oauth.terry;

import com.liferay.portal.kernel.oauth.OAuthException;
import com.liferay.portal.kernel.util.Validator;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

public class OAuthManagerImpl {

	public OAuthManagerImpl(
		String key, String secret, String accessURL, String authorizeURL,
		String requestURL, String callbackURL, String scope,
		Verb accessTokenVerb, Verb requestTokenVerb, int signatureServiceType) {

		if (Validator.isNull(callbackURL)) {
			callbackURL = "oob";
		}

		OAuthConfig config = new OAuthConfigImpl(
			key, secret, callbackURL, SignatureType.Header, scope, null);

		OAuthApiImpl api = new OAuthApiImpl(
			accessURL, authorizeURL, requestURL,
			VerbTranslator.translate(accessTokenVerb), VerbTranslator.translate(
				requestTokenVerb), signatureServiceType);

		_oAuthService =
			((org.scribe.builder.api.Api)api.getWrappedApi()).createService(
				(org.scribe.model.OAuthConfig)config.getWrappedOAuthConfig());
	}

	public OAuthManagerImpl(
		String key, String secret, String accessURL, String authorizeURL,
		String callbackURL, String scope, Verb accessTokenVerb,
		int extractorType) {

		if (Validator.isNull(callbackURL)) {
			callbackURL = "oob";
		}

		OAuthConfig config = new OAuthConfigImpl(
			key, secret, callbackURL, SignatureType.Header, scope, null);

		OAuthApiImpl api = new OAuthApiImpl(
			accessURL, authorizeURL, VerbTranslator.translate(accessTokenVerb),
			extractorType);

		_oAuthService =
			((org.scribe.builder.api.Api)api.getWrappedApi()).createService(
				(org.scribe.model.OAuthConfig)config.getWrappedOAuthConfig());
	}

	public TokenImpl getAccessToken(TokenImpl requestToken, VerifierImpl verifier)
		throws OAuthException {

		Token t = (Token)requestToken.getWrappedToken();
		org.scribe.model.Verifier v = (org.scribe.model.Verifier)verifier.getWrappedVerifier();

		
		try {
			return new TokenImpl(_oAuthService.getAccessToken(t,v));
		}
		catch (Exception e) {
			throw new OAuthException(e);
		}
	}

	public String getAuthorizeURL(TokenImpl requestToken) throws OAuthException {
		try {
			return _oAuthService.getAuthorizationUrl(
				(Token)requestToken.getWrappedToken());
		}
		catch (Exception e) {
			throw new OAuthException(e);
		}
	}

	public TokenImpl getRequestToken() throws OAuthException {
		try {
			return new TokenImpl(_oAuthService.getRequestToken());
		}
		catch (Exception e) {
			throw new OAuthException(e);
		}
	}

	public String getVersion() throws OAuthException {
		try {
			return _oAuthService.getVersion();
		}
		catch (Exception e) {
			throw new OAuthException(e);
		}
	}

	public void signRequest(TokenImpl accessToken, OAuthRequestImpl oAuthRequest)
		throws OAuthException {

		try {
			_oAuthService.signRequest(
				(Token)accessToken.getWrappedToken(),
				(org.scribe.model.OAuthRequest)
					oAuthRequest.getWrappedOAuthRequest());
		}
		catch (Exception e) {
			throw new OAuthException(e);
		}
	}

	private OAuthService _oAuthService;

}

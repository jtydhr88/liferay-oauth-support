package com.liferay.portal.kernel.oauth.terry;

import com.liferay.portal.kernel.oauth.OAuthException;

public class OAuthFactoryImpl {
	
	public static OAuthManagerImpl createOAuthManager(
			String key, String secret, String accessURL, String authorizeURL,
			String requestURL, String callbackURL, String scope,
			Verb accessTokenVerb, Verb requestTokenVerb,
			int signatureServiceType)
		throws OAuthException {

		try {
			return new OAuthManagerImpl(
				key, secret, accessURL, authorizeURL, requestURL, callbackURL,
				scope, accessTokenVerb, requestTokenVerb, signatureServiceType);
		}
		catch (Exception e) {
			throw new OAuthException(e);
		}
	}

	
	public static OAuthManagerImpl createOAuthManager(
			String key, String secret, String accessURL, String authorizeURL,
			String callbackURL, String scope, Verb accessTokenVerb,
			int extractorType)
		throws OAuthException {

		try {
			return new OAuthManagerImpl(
				key, secret, accessURL, authorizeURL, callbackURL, scope,
				accessTokenVerb, extractorType);
		}
		catch (Exception e) {
			throw new OAuthException(e);
		}
	}

	
	public static OAuthRequestImpl createOAuthRequest(Verb verb, String url)
		throws OAuthException {

		try {
			return new OAuthRequestImpl(
				new org.scribe.model.OAuthRequest(
					VerbTranslator.translate(verb), url));
		}
		catch (Exception e) {
			throw new OAuthException(e);
		}
	}

	
	public static TokenImpl createToken(String token, String secret)
		throws OAuthException {

		try {
			return new TokenImpl(new org.scribe.model.Token(token, secret));
		}
		catch (Exception e) {
			throw new OAuthException(e);
		}
	}

	
	public static VerifierImpl createVerifier(String verifier) throws OAuthException {
		try {
			return new VerifierImpl(new org.scribe.model.Verifier(verifier));
		}
		catch (Exception e) {
			throw new OAuthException(e);
		}
	}

}

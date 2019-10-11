package com.liferay.portal.kernel.oauth.terry;

public class VerifierImpl {
	public VerifierImpl(org.scribe.model.Verifier verifier) {
		_verifier = verifier;
	}

	public Object getWrappedVerifier() {
		return _verifier;
	}

	private org.scribe.model.Verifier _verifier;
}

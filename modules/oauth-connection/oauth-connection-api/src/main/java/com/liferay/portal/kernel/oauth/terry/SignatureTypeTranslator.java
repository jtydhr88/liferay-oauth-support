package com.liferay.portal.kernel.oauth.terry;

public class SignatureTypeTranslator {

	public static SignatureType translate(
		org.scribe.model.SignatureType signatureType) {

		if (signatureType == org.scribe.model.SignatureType.Header) {
			return SignatureType.Header;
		}
		else if (signatureType == org.scribe.model.SignatureType.QueryString) {
			return SignatureType.QueryString;
		}
		else {
			throw new IllegalArgumentException(
				"Unknown signature type " + signatureType);
		}
	}

	public static org.scribe.model.SignatureType translate(
		SignatureType signatureType) {

		if (signatureType == SignatureType.Header) {
			return org.scribe.model.SignatureType.Header;
		}
		else if (signatureType == SignatureType.QueryString) {
			return org.scribe.model.SignatureType.QueryString;
		}
		else {
			throw new IllegalArgumentException(
				"Unknown signature type " + signatureType);
		}
	}

} 

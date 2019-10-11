package com.liferay.portal.kernel.oauth.terry;

public class VerbTranslator {

	public static Verb translate(org.scribe.model.Verb verb) {
		if (verb == org.scribe.model.Verb.DELETE) {
			return Verb.DELETE;
		}
		else if (verb == org.scribe.model.Verb.GET) {
			return Verb.GET;
		}
		else if (verb == org.scribe.model.Verb.HEAD) {
			return Verb.HEAD;
		}
		else if (verb == org.scribe.model.Verb.OPTIONS) {
			return Verb.OPTIONS;
		}
		else if (verb == org.scribe.model.Verb.PATCH) {
			return Verb.PATCH;
		}
		else if (verb == org.scribe.model.Verb.POST) {
			return Verb.POST;
		}
		else if (verb == org.scribe.model.Verb.PUT) {
			return Verb.PUT;
		}
		else if (verb == org.scribe.model.Verb.TRACE) {
			return Verb.TRACE;
		}
		else {
			throw new IllegalArgumentException("Unknown verb " + verb);
		}
	}

	public static org.scribe.model.Verb translate(Verb verb) {
		if (verb == Verb.DELETE) {
			return org.scribe.model.Verb.DELETE;
		}
		else if (verb == Verb.GET) {
			return org.scribe.model.Verb.GET;
		}
		else if (verb == Verb.HEAD) {
			return org.scribe.model.Verb.HEAD;
		}
		else if (verb == Verb.OPTIONS) {
			return org.scribe.model.Verb.OPTIONS;
		}
		else if (verb == Verb.PATCH) {
			return org.scribe.model.Verb.PATCH;
		}
		else if (verb == Verb.POST) {
			return org.scribe.model.Verb.POST;
		}
		else if (verb == Verb.PUT) {
			return org.scribe.model.Verb.PUT;
		}
		else if (verb == Verb.TRACE) {
			return org.scribe.model.Verb.TRACE;
		}
		else {
			throw new IllegalArgumentException("Unknown verb " + verb);
		}
	}
}

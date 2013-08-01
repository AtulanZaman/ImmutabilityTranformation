package ece750.immutable.atulan;

import java.util.ArrayList;
import java.util.List;

/**
 * We want to generate MutableObject from ImmutableObject, and then replace
 * uses of ImmutableObject with MutableObject.
 */
public final class ObjectMutable {
	static List<String> tokens;

	public ObjectMutable() {
		ObjectMutable.tokens = new ArrayList<String>();
	}
	
	public ObjectMutable(final List<String> tokens) {
		ObjectMutable.tokens = tokens;
	}
	
	public ObjectMutable append(final String token) {
		// mutate our list of tokens
		tokens.add(token);
		// for client compatibility
		return this;
	}

	public String toString() {
		return "Object: " + tokens;
	}
}

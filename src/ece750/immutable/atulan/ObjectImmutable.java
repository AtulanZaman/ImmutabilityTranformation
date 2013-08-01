package ece750.immutable.atulan;

import org.parboiled.common.ImmutableList;

public class ObjectImmutable {

	private final ImmutableList<String> tokens;
	
	public ObjectImmutable() {
		this.tokens = ImmutableList.of();
	}
	
	public ObjectImmutable(final ImmutableList<String> tokens) {
		this.tokens = tokens;
	}
	
	/**
	 * Construct a new Object with an extra token.
	 * @param token
	 * @return
	 */
	public ObjectImmutable append(final String token) {
		// don't mutate this
		// construct a new list and a new Object
		return new ObjectImmutable(tokens.append(token));
	}
	
	public String toString() {
		return "ObjectImmutable: " + tokens;
	}

}
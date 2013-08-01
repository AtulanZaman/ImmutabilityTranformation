package ece750.immutable.atulan;
import java.util.ArrayList;
import java.util.List;

import org.parboiled.common.ImmutableList;

	/**
	 * This class is deeply immutable.
	 */
public class Motivation{
	final class Atulan {

		final ImmutableList<String> tokens;
		
		public Atulan() {
			this.tokens = ImmutableList.of();
		}
		
		public Atulan(final ImmutableList<String> tokens) {
			this.tokens = tokens;
		}
		
		/**
		 * Construct a new Atulan with an extra token.
		 * @param token
		 * @return
		 */
		public Atulan append(final String token) {
			// don't mutate this
			// construct a new list and a new Atulan
			return new Atulan(tokens.append(token));
		}
		
		public String toString() {
			return "Atulan: " + tokens;
		}
	}


	/**
	 * We want to generate MutableAtulan from Atulan, and then replace
	 * uses of Atulan with MutableAtulan.
	 */
	final class MutableAtulan {
		List<String> tokens;

		public MutableAtulan() {
			this.tokens = new ArrayList<String>();
		}
		
		public MutableAtulan(final List<String> tokens) {
			this.tokens = tokens;
		}
		
		public MutableAtulan append(final String token) {
			// mutate our list of tokens
			tokens.add(token);
			// for client compatibility
			return this;
		}

		public String toString() {
			return "Atulan: " + tokens;
		}
	}

	/**
	 * This client can be transformed to use the MutableAtulan class,
	 * because the Atulan objects are discarded after the append call.
	 * There are four Atulan objects constructed here, but only one is
	 * necessary (if we have mutation).
	 * 
	 * Analysis needs to check: do we discard a1, a2, a3?
	 * In other words, do we discard after each append method?
	 * Also, do we discard after EVERY append method from a given starting object?
	 * In other words, do a1, a2, a3, and a4 all represent different states
	 * of the same mutable conceptual object?
	 */
	final class Client1a {
		public  void main(final String[] args) { //TODO
			Atulan a = new Atulan(); // create a1
			a = a.append("x"); // create a2, discard a1
			a = a.append("y"); // create a3, discard a2
			a = a.append("z"); // create a4, discard a3
			System.out.println(a); // read a4
		}
	}

	/**
	 * This client CANNOT be transformed to use the MutableAtulan class,
	 * because the first Atulan object is not discarded.
	 * 
	 * Probably need an object-sensitive points-to analysis.
	 * Might also need a flow sensitive analysis for the client.
	 */
	final class Client1b {

		Object escaper = null; //TODO
		
		public void main(final String[] args) { //TODO
			Atulan a = new Atulan(); // create a1
			escape(a); // save a1 for later
			a = a.append("x"); // create a2, DO NOT discard a1 (saved in escaper)
			a = a.append("y"); // create a3, discard a2
			a = a.append("z"); // create a4, discard a3
			System.out.println(a); // read a4
			System.out.println(escaper); // read a1
		}
		
		void escape(Object o) { //TODO
			// go stick this object in the heap somewhere
			escaper = o;
			return; 
		}
	}

	/**
	 * The result of the transformation. Equivalent to Client1a.
	 * Client1b cannot be transformed in this way.
	 */
	final class Client2 {
		public void main(final String[] args) { //TODO
			MutableAtulan a = new MutableAtulan(); // create a1
			a.append("x"); // mutate a1
			a.append("y"); // mutate a1
			a.append("z"); // mutate a1
			System.out.println(a);
		}
	}
}
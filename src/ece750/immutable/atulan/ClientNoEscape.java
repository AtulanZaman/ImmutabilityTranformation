package ece750.immutable.atulan;


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
public final class ClientNoEscape {
	public static void main(final String[] args) { //TODO
		ObjectImmutable a = new ObjectImmutable(); // create a1
		a = a.append("x"); // create a2, discard a1
		a = a.append("y"); // create a3, discard a2
		a = a.append("z"); // create a4, discard a3
		System.out.println(a); // read a4
	}
}
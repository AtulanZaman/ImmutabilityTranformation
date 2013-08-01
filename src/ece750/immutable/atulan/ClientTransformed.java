package ece750.immutable.atulan;

/**
 * The result of the transformation. Equivalent to Client1a.
 * Client1b cannot be transformed in this way.
 */
public final class ClientTransformed {
	public static void main(final String[] args) {
		ObjectMutable a = new ObjectMutable(); // create a1
		a.append("x"); // mutate a1
		a.append("y"); // mutate a1
		a.append("z"); // mutate a1
		System.out.println(a);
	}
}

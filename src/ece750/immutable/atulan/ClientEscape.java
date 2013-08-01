package ece750.immutable.atulan;

/**
 * This client CANNOT be transformed to use the MutableAtulan class,
 * because the first Atulan object is not discarded.
 * 
 * Probably need an object-sensitive points-to analysis.
 * Might also need a flow sensitive analysis for the client.
 */
public final class ClientEscape{

	static Object escaper = null; //TODO
	
	static void main(final String[] args) { //TODO
		ObjectImmutable a = new ObjectImmutable(); // create a1
		escape(a); // save a1 for later
		a = a.append("x"); // create a2, DO NOT discard a1 (saved in escaper)
		a = a.append("y"); // create a3, discard a2
		a = a.append("z"); // create a4, discard a3
		System.out.println(a); // read a4
		System.out.println(escaper); // read a1
		
//		T foo = new T(); foo.b = a; foo.b.x = 5; // a.x is now 5.
//		Object foo.b = a;
	
	}
	
	public static void escape(Object o) { //TODO
		// go stick this object in the heap somewhere
		escaper = o;
		return; 
	}
	
	// Test method to see if object escapes with return
	public void testMethod(){
		ObjectImmutable a = new ObjectImmutable();
		a = a.append("a");
		ObjectImmutable b = new ObjectImmutable();
		//a escapes;
		b = escapewithreturn(a);
		a = a.append("c");
		System.out.println(a);
	}
	
	// When it is passed to a a static method, that does not assign the parameter to a static variable, does it still make it globalescape?
	// Probably not.
	public ObjectImmutable escapewithreturn(ObjectImmutable a){
		ObjectImmutable o;
		o = a;
		o = o.append("b");
		return o;
	}
}

package ece750.immutable.atulan;

/*This test is class is here to test for immutability when an immutable object is assigned to a another object by field referencing
 * The Test fails. Therefore when we do an assignment in java, it is not pass by value, it is a direct reference. It is only pass by
 * value when it is passed in as a parameter*/

/* The case shown here shows the value does not change if the object passed in is Immutable*/

public class PassByValueTest {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PassByValueTest p = new PassByValueTest();
		Object b = new Object();
		
		T t1 = new T(1);
		System.out.println("This is t1 first: "+t1.getb( ));
		R t2 = new R();
		t2.a = t1;
		t2.a = t2.a.setb(3);
		System.out.println("This is t2: "+t2.a.getb());
		System.out.println("This is t1 after which was changed by t2!!: "+t1.getb());
	}
	
	private PassByValueTest(){
		
	}
}

class T{
	private Integer b;
	
	public T(Integer b){
		this.b  = b;
	}
	
	public Integer getb(){
		return b;
	}
	public T setb(Integer newb){
		return new T(newb);
	}
}

class R{
	T a;
	public R(){
	}
}
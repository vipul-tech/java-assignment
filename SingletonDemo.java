public class SingletonDemo{
	public static void main(String args[]){
		 A x = A.getA();
		 A y = A.getA();
		 A z = A.getA();
		 B m = B.getB();
		 System.out.println("Hashcode of x is "+ x.hashCode());
        	 System.out.println("Hashcode of y is "+ y.hashCode());
        	 System.out.println("Hashcode of z is "+ z.hashCode());
	}
}

class A{
	private static A obj=null;
	A(){
		System.out.println("A object created");
	}
	public static A getA(){
		if (obj == null)
            		obj = new A();
  	 	return obj;  
 	}   
		
}

class B extends A{
	private static B obj=new B();
	private B(){
		System.out.println("B object created");
	}
	public static B getB(){
  		return obj;  
 	}  
}
public class newFeatures{
	public static void main(String args[]){
		I i1= ()->System.out.println("Hello from lambda expression");
		i1.abc();
	}
}
interface I{
	void abc();
}
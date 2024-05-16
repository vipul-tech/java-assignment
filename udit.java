import java.util.Scanner;

class udit{
	public static void main(String args[]){
		int x,y,z;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter two numbers");
		x=s.nextInt();
		y=s.nextInt();
		z=x*y;
		System.out.println("Product : "+z);
	}
}
public class Demo{
	public static void main(){
		try{
			System.out.println("Enter class name");
			class c=class.forName(new Scanner(System.in).next());
			System.out.println("This is from "+c+);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}	
}
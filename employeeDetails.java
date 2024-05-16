import java.util.*;

class emp{
	String name;
	int age;
	int salary;
	String design;

	public emp(){
		this.create();
	}

	public void create(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name : ");
		name=sc.nextLine();
		System.out.print("Enter age : ");
		age=sc.nextInt();
		System.out.print("Enter salary : ");
		salary=sc.nextInt();
		sc.nextLine();
		System.out.print("Enter designation : ");
		design=sc.nextLine();
	}

	public void display(){
		System.out.println("-------------");
		System.out.println(name);
		System.out.println("Age : "+age);
		System.out.println("Salary : "+salary);
		System.out.println(design);
		System.out.println("-------------");
	}
	public void raiseSalary(){
		double i=salary*0.3f;
		salary+=i;
	}
}

public class employeeDetails{
	public static void main(String args[]){
		emp[] e = new emp[100];
		int count=0;
		int ch;
		do {
			System.out.println("-----------------");
			System.out.println("1.Create");
			System.out.println("2.Display");
			System.out.println("3.Raise Salary");
			System.out.println("4.Exit");
			System.out.println("-----------------");
			System.out.print("Enter choice : ");
			Scanner sc = new Scanner(System.in);
			ch=sc.nextInt();
			switch(ch)
			{
				case 1:
					e[count++]=new emp();
					break;
				case 2:
					for(int i=0;i<count;i++)
						e[i].display();
					break;
				case 3:
					for(int i=0;i<count;i++)
						e[i].raiseSalary();
					break;
			}
		}while(ch!=4);
	}
}


import java.util.*;

public class EmpDetails{
	public static void main(String args[]){
		Emp[] e = new Emp[100];
		int count=0;
		int ch,c;
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
					do{
						System.out.println("---------------");
						System.out.println("1.Clerk");
						System.out.println("2.Programmer");
						System.out.println("3.Manager");
						System.out.println("4.Exit");
						System.out.println("---------------");
						System.out.print("Enter choice : ");
						Scanner s = new Scanner(System.in);
						c=s.nextInt();
						switch(c){
							case 1:
								e[count++]=new Clerk();
								break;
							case 2:
								e[count++]=new Programmer();
								break;
							case 3:
								e[count++]=new Manager();
								break;
						}
					}while(c!=4);
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

abstract class Emp{
	String name;
	int age;
	int salary;
	String design;

	public Emp(){
		this.create();
	}

	public void create(){
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------");
		System.out.print("Enter name : ");
		name=sc.nextLine();
		System.out.print("Enter age : ");
		age=sc.nextInt();
		sc.nextLine();
	}

	public void display(){
		System.out.println("-------------");
		System.out.println(name);
		System.out.println("Age : "+age);
		System.out.println("Salary : "+salary);
		System.out.println(design);
	}

	public abstract void raiseSalary();
}

final class Clerk extends Emp{
	Clerk(){
		salary=10000;
		design="Clerk";
	}
	public void raiseSalary(){
		salary+=2000;
	}
}

final class Programmer extends Emp{
	Programmer(){
		salary=25000;
        	design="Programmer";
	}
	public void raiseSalary(){
		salary+=5000;
	}
}

final class Manager extends Emp{
	Manager(){
		salary=80000;
        	design="Manager";
	}
	public void raiseSalary(){
		salary+=10000;
	}
}


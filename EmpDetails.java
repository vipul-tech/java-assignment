package emp.assignment;

import java.util.*;

abstract class Emp{
	String name;
	int age;
	int salary;
	String design;
	static int counter=0;
	public Emp(){
		this.create();
		counter++;
	}

	public void create(){
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------");
		System.out.print("Enter name : ");
		name=sc.nextLine();
		boolean validInput=false;
		while(!validInput){
			System.out.print("Enter age : ");
			String input=sc.next();
			try{
				age=Integer.parseInt(input);
				sc.nextLine();
				if(age<21||age>60)
					throw new NotValidAgeException("Please enter age between 21 and 60");
				validInput=true;
                	}
			catch(NotValidAgeException ex){
				System.out.println(ex);
			}
			catch(Exception exc){
				System.out.println(exc);
				System.out.println("Invalid Input!...");
			}
		}
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

public class EmpDetails{
	public static void main(String args[]){
		Emp[] e = new Emp[100];
		int count=0;
		int ch=0,c=0;
		do {
			System.out.println("-----------------");
			System.out.println("1.Create");
			System.out.println("2.Display");
			System.out.println("3.Raise Salary");
			System.out.println("4.Exit");
			System.out.println("-----------------");
			try{
				System.out.print("Enter choice : ");
				Scanner sc = new Scanner(System.in);
				ch=sc.nextInt();
				if(ch<1||ch>4)
					throw new NotValidChoiceException("Enter choice between 1 and 4");
			}
			catch(NotValidChoiceException ex){
				System.out.println(ex);
			}	
			catch(Exception ex){
				System.out.println(ex);
				System.out.println("Invalid Input!");
			}
				
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
						try{
							System.out.print("Enter choice : ");
							Scanner s = new Scanner(System.in);
							c=s.nextInt();
							if(c<1||c>4)
								throw new NotValidChoiceException("Enter choice between 1 and 4");
						}
						catch(NotValidChoiceException ex){
							System.out.println(ex);
						}	
						catch(Exception ex){
							System.out.println(ex);
							System.out.println("Invalid Input!");
						}
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
					System.out.println("Total employee objects created : " + Emp.counter);
					break;
				case 3:
					for(int i=0;i<count;i++)
						e[i].raiseSalary();
					break;
			}
		}while(ch!=4);
	}
}

class NotValidAgeException extends RuntimeException
{
	public NotValidAgeException()
	{
	}
	public NotValidAgeException(String msg)
	{
		super(msg);
	}	
}

class NotValidChoiceException extends RuntimeException
{
	public NotValidChoiceException()
	{
	}
	public NotValidChoiceException(String msg)
	{
		super(msg);
	}	
}
import java.util.*;
import java.util.stream.*;

enum Gender{
	MALE,FEMALE;
}

enum Desig{
	TESTER,PROGRAMMER,MANAGER,EXECUTIVE;
}

enum Dept{
	QA,SALES,DEVELOPMENT,MANUFACTURING;
}

class Employee{
	int id,age,salary;
	String name;
	Desig desig;
	Gender gender;	
	Dept dept;

	Employee(int id,String name,int age,int salary,Desig desig,Dept dept,Gender gender){
		this.id=id;
		this.name=name;
		this.age=age;
		this.salary=salary;
		this.desig=desig;
		this.dept=dept;
		this.gender=gender;
	}

	public String toString(){
		System.out.println("ID : "+id);
		System.out.println("Name : "+name);
		System.out.println("Age : "+age);
		System.out.println("Salary : "+salary);
		System.out.println("Designation : "+desig);
		System.out.println("Department : "+dept);
		System.out.println("Gender : "+gender);
		System.out.println("---------------------");
		return "";
	}
}

public class StreamEmployee{
	public static void main(String args[]){
		LinkedList<Employee> list= new LinkedList<Employee>();
		list.add(new Employee(1,"Sonam",25,35000,Desig.Tester,DEPT.Sales,GENDER.Female));
		list.add(new Employee(2,"Sunil",22,38000,Desig.Programmer,DEPT.QA,GENDER.Male));
		list.add(new Employee(3,"Sourav",28,47000,Desig.Programmer,DEPT.Manufacturing,GENDER.Male));
		list.add(new Employee(4,"Richa",35,55000,Desig.Manager,DEPT.QA,GENDER.Female));
		list.add(new Employee(5,"Vipul",22,78000,Desig.Programmer,DEPT.Manufacturing,GENDER.Male));
		list.add(new Employee(6,"Kavya",53,39000,Desig.Executive,DEPT.Sales,GENDER.Female));
		list.add(new Employee(7,"Akansha",35,55000,Desig.Programmer,DEPT.Development,GENDER.Female));
		list.add(new Employee(8,"Smriti",37,45000,Desig.Manager,DEPT.Manufacturing,GENDER.Female));
		list.add(new Employee(9,"Rohit",46,48000,DESIG.Manager,DEPT.Development,GENDER.Male));
		list.add(new Employee(10,"Ankit",32,32000,DESIG.Tester,DEPT.QA,GENDER.Male));
		list.add(new Employee(11,"Praveet",44,44000,DESIG.Manager,DEPT.Development,GENDER.Male));
		list.add(new Employee(12,"Amit",58,67000,DESIG.Executive,DEPT.Manufacturing,GENDER.Male));
		list.add(new Employee(13,"Anshika",29,47000,DESIG.Executive,DEPT.QA,GENDER.Female));
		list.add(new Employee(14,"Anmol",34,42000,DESIG.Programmer,DEPT.Development,GENDER.Female));
		list.add(new Employee(15,"Abhishek",49,29000,DESIG.Manager,DEPT.Sales,GENDER.Male));
		list.add(new Employee(16,"Dolly",43,49000,DESIG.Tester,DEPT.Manufacturing,GENDER.Female));
		list.add(new Employee(17,"Himanshu",27,55000,DESIG.Tester,DEPT.Development,GENDER.Male));
		list.add(new Employee(18,"Robin",36,69000,DESIG.Programmer,DEPT.Sales,GENDER.Male));
		list.add(new Employee(19,"Riya",48,56000,DESIG.Tester,DEPT.QA,GENDER.Female));
		list.add(new Employee(20,"Sonakshi",41,89000,DESIG.Manager,DEPT.Sales,GENDER.Female));
		list.add(new Employee(21,"Ankush",40,52000,DESIG.Executive,DEPT.Development,GENDER.Male));
		list.add(new Employee(22,"Niraj",55,59000,DESIG.Executive,DEPT.Manufacturing,GENDER.Male));
		list.add(new Employee(23,"Nilam",57,90000,DESIG.Programmer,DEPT.QA,GENDER.Female));
		list.add(new Employee(24,"Naresh",52,62000,DESIG.Manager,DEPT.Development,GENDER.Male));
		list.add(new Employee(25,"Vivek",23,42000,DESIG.Tester,DEPT.Sales,GENDER.Male));
		list.add(new Employee(26,"Vikash",29,35000,DESIG.Executive,DEPT.Sales,GENDER.Male));
		list.add(new Employee(27,"Tanu",30,41000,DESIG.Tester,DEPT.Manufacturing,GENDER.Female));
		list.add(new Employee(28,"Neha",42,61000,DESIG.Programmer,DEPT.Manufacturing,GENDER.Female));
		list.add(new Employee(29,"Sukesh",55,30000,DESIG.Manager,DEPT.QA,GENDER.Male));
		list.add(new Employee(30,"Aditya",45,49000,DESIG.Executive,DEPT.Development,GENDER.Male));
		int ch1=0;

        	do
		{
			System.out.println("-----------------");
			System.out.println("  1. Second Highest Salary Employee ");
			System.out.println("  2. Number of Male and Female Employees ");
			System.out.println("  3. Expensive Department in the Company ");
            		System.out.println("  4. Age of Employees Company ");
			System.out.println("  5. Total Salary Designation Wise ");
			System.out.println("  6. Exit ");
			System.out.println("-----------------");
			System.out.print("Enter choice : ");
			try {
                		ch1 = new Scanner(System.in).nextInt();      
            		}
			catch (Exception e){
                		System.out.println("Please Enter correct choice (Number Only)");
                		continue;
            		}
			if(ch1==1)
			{
				List<Employee> m1 = list.stream().sorted((emp1,emp2) -> (emp2.salary-emp1.salary)).skip(1).limit(1).collect(Collectors.toList());
        			System.out.println(m1);
			}
			if(ch1==2)
			{
				Map<GENDER, Long> m2 = list.stream().collect(Collectors.groupingBy(e->e.gender, Collectors.counting()));
				System.out.println(m2);
			}
			if(ch1==3)
			{
			    	Map<DEPT, Integer> m3 = list.stream().collect(Collectors.groupingBy(e->e.dept, Collectors.summingInt(e->e.salary)));
				System.out.println(m3);
				Set set=m3.entrySet();
				int c=0;
				DEPT d=null;
				Iterator it = set.iterator();
				while(it.hasNext()){
					Map.Entry m = (Map.Entry) it.next();
					if((Integer) m.getValue() > c)
					{
						c=(Integer)m.getValue();
						d=(DEPT)m.getKey();
					}
				}
				System.out.println("Expensive department is "+d+" with value of "+c);
			}
			if (ch1==4){
			    	Long x = list.stream().filter(e->e.age > 20 && e.age <= 30).collect(Collectors.counting());
				Long y = list.stream().filter(e->e.age > 30 && e.age <= 40).collect(Collectors.counting());
				Long z = list.stream().filter(e->e.age > 40).collect(Collectors.counting());

				List<Long> l = Arrays.asList(x,y,z);  
        			Long max = l.stream().max(Long::compare).get();
  
	        		if(x==max)
					System.out.println("The company is Youth and total number of employees between age 21 & 30 are "+max);
				else if(y==max)
					System.out.println("The company is Midage and total number of employees between age 31 & 40 are "+max);
				else
					System.out.println("The company is Senior and total number of employees above age 40 are "+max);
            			}
			if (ch1==5){
				Map<DESIG, Integer> m5 = list.stream().collect(Collectors.groupingBy(e->e.desig, Collectors.summingInt(e->e.salary)));
				System.out.println(m5);
			}
		}while(ch1!=6);
		return;
	}
}
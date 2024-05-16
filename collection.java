import java.util.*;

class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private int age;
 
public Employee(int id, String name, int age) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
}
 
public int getId() {
	return id;
}
 
public void setId(int id) {
	this.id = id;
}
 
public String getName() {
	return name;
}
 
public void setName(String name) {
	this.name = name;
}
 
public int getAge() {
	return age;
}
 
public void setAge(int age) {
	this.age = age;
}
 

public int compareTo(Employee o) {
	boolean flag4;
	int ch = 0;
	System.out.print("1. Sort by ID.");
	System.out.print("2. Sort by name. ");
	System.out.print("3. Sort by age. ");
	Scanner sch = new Scanner(System.in);
		do{
			String digit = "\\d";
    			System.out.print("Enter the choice : ");
      			String c12 = sch.next();
      			flag4 = c12.matches(digit);
		try {
			if(!flag4){
				throw new InvalidChoiceException("Please Enter a choice of type integer.");
			}
			ch = Integer.parseInt(c12);
			if(ch > 3){
				flag4 = false;
				throw new InvalidChoiceException("Please Enter a Choice Between 1 and 4.");
			}
		
		}
		catch(InvalidChoiceException p){
			System.out.println(p);
		}
		}while(!flag4); 
	if(ch == 1){
	if (o.getId() > this.getId()) {
		return 1;
	}else if (o.getId() < this.getId()) {
		return -1;
  	}
	return 0; 
	}else if(ch == 2){
		return this.getName().compareTo(o.getName());
	}else{
		if (o.getAge() > this.getAge()) {
			return 1;
		}else if (o.getAge() < this.getAge()) {
			return -1;
		}
		return 0;
	}
}
 
public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
 
}

public class collection {
 
	public static void main(String[] args) {
 
	List<Employee> emps = new ArrayList<>();
 
	emps.add(new Employee(1, "abhay", 22));
	emps.add(new Employee(2, "anand", 23));
	emps.add(new Employee(3, "aayushi", 24));
 

	Iterator<Employee> it = emps.iterator();

	Collections.sort(emps);
 
	Collections.sort(emps, Collections.reverseOrder());
 
	System.out.println("After sorting list of employees: ");
	it = emps.iterator();
	while (it.hasNext()){
			System.out.println(it.next());
		}
 
	}
 
}

class InvalidChoiceException extends Exception 
{
	public InvalidChoiceException()
	{
	}
	public InvalidChoiceException(String msg)
	{
		super(msg);
	}	
	
}

import java.util.*;
import java.util.stream.*;

class Employee{
    String name;
    int age;
    int salary;
    String desig;

    public Employee(String name, int age, int salary, String desig){
	this.name=name;
	this.age=age;
	this.salary=salary;
	this.desig=desig;
    }
    public String toString(){
	String str = "( "+name+", "+age+", "+salary+", "+desig+" )";
	return str;
    }
}

public class Abc{
    public static void main(String[] args){
	List<Employee>list=new ArrayList<Employee>();
	list.add(new Employee("Rakesh",25,48000,"Programmer"));
	
	list.add(new Employee("Sukesh",27,48000,"Manager"));
	
	list.add(new Employee("Ramesh",22,38000,"Manager"));
	
	list.add(new Employee("Naresh",29,38000,"Tester"));
	
	list.add(new Employee("Ganesh",21,38000,"Programmer"));
	
	Map<Boolean,List<Employee>> m1 = list.stream().collect(Collectors.partitioningBy(e->e.age>25));
	System.out.println(m1);
	System.out.println("*****************************************************************************");
	Map<Boolean,Long> m2 = list.stream().collect(Collectors.partitioningBy(e->e.age>25 ,Collectors.counting()));
	System.out.println(m2);
	System.out.println("*****************************************************************************");
	Map<String,List<Employee>> m3 = list.stream().collect(Collectors.groupingBy(e->e.desig));
	System.out.println(m3);
	System.out.println("*****************************************************************************");
	Map<String,Long> m4 = list.stream().collect(Collectors.groupingBy(e->e.desig,Collectors.counting()));
	System.out.println(m4);
	System.out.println("*****************************************************************************");
	Map<String,List<String>> m5 = list.stream().collect(Collectors.groupingBy(e->e.desig,Collectors.mapping(e->e.name.toUpperCase(),Collectors.toList())));
	System.out.println(m5);
	System.out.println("*****************************************************************************");
	Map<String,Integer> m6 = list.stream().collect(Collectors.groupingBy(e->e.desig,Collectors.summingInt(e->e.salary)));
	System.out.println(m6);
	System.out.println("*****************************************************************************");
    }
} 
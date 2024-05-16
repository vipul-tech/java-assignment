import java.util.*;
class Student{
    int rollno;
    String name;
    int age;
    Student(int rollno, String name, int age){
	this.rollno=rollno;
	this.name=name;
	this.age=age;
    }
}

public class Second{
    public static void main(String[] args){
	Student s1 = new Student(101,"Vipul Kumar",21);
	Student s2 = new Student(102,"Ramesh Kumar",22);
	Student s3 = new Student(103,"Abhishek Kumar",22);
	Student s4 = new Student(104,"Pinky Kumari",20);
	Student s5 = new Student(105,"Shradha Kumari",19);
	ArrayList<Student> list = new ArrayList<Student>();
	list.add(s1);
	list.add(s2);
	list.add(s3);
	list.add(s4);
	list.add(s5);
	Iterator itr = list.iterator();
	while(itr.hasNext()){
	    Student st = (Student)itr.next();
	    System.out.println(st.rollno+" "+st.name+" "+st.age);
	}
	
    }
}
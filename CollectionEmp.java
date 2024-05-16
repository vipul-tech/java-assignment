import java.util.*;

class Emp{
	int eid;
	String name;
	int age;

	public Emp(int eid, String name, int age){
		this.eid=eid;
		this.name=name;
		this.age=age;
	}

	public void display(){
		System.out.println("EmpId : "+eid);
		System.out.println("Name : "+name);
		System.out.println("Age : "+age);
	}
}

public class CollectionEmp{
	public static void main(String args[]){
		int ch=0;
		LinkedList <Emp> ll = new LinkedList <Emp> ();
		ll.add(new Emp(3,"Ramesh",35));
		ll.add(new Emp(5,"Sukesh",23));
		ll.add(new Emp(1,"Naresh",22));
		ll.add(new Emp(4,"Dolly",31));
		ll.add(new Emp(2,"Jignesh",30));
		do {
			System.out.println("-----------------");
			System.out.println("1.Sort by Id");
			System.out.println("2.Sort by Name");
			System.out.println("3.Sort by Age");
			System.out.println("4.Sort by Id in reverse order");
			System.out.println("5.Sort by Name in reverse order");
			System.out.println("6.Sort by Age in reverse order");
			System.out.println("7.Exit");
			System.out.println("-----------------");
			Scanner sc = new Scanner(System.in);
			sc.nextInt();
				
			switch(ch)
			{
				case 1: 
					Collections.sort(ll,new IdSorter);
					break;
				case 2:
					Collections.sort(ll,new NameSorter);
					break;
				case 3:
					Collections.sort(ll,new AgeSorter);
					break;
				case 4:
					Collections.sort(ll,new IdSorterReverse);
					break;
				case 5:
					Collections.sort(ll,new NameSorterRecerse);
					break;
				case 6:
					Collections.sort(ll,new AgeSorterReverse);
					break;
				default:
					System.exit();
			}
		}while(true);
	}
}
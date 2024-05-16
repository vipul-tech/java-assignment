import java.util.*;
class NameSorter implements Comparator{
	public String compare(Emp e1,Emp e2){
		String n1=e1.name;
		String n2=e2.name;
		return n1.compareTo(n2);
	}
}

class AgeSorter implements Comparator{
	public int compare(Emp e1,Emp e2){
		return e1.age.compareTo(e2.age);
	}
}

class IdSorter implements Comparator{
	public int compare(Emp e1,Emp e2){
		return e1.eid.compareTo(e2.eid);
	}
}

class NameSorterReverse implements Comparator{
	public String compare(Emp e1,Emp e2){
		String n1=e1.name;
		String n2=e2.name;
		return n2.compareTo(n1);
	}
}

class AgeSorterReverse implements Comparator{
	public int compare(Emp e1,Emp e2){
		return e2.age.compareTo(e1.age);
	}
}

class IdSorterReverse implements Comparator{
	public int compare(Emp e1,Emp e2){
		return e2.eid.compareTo(e1.eid);
	}
}
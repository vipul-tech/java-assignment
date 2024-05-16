import java.util.*;

public class Hashset1{
    public static void main(String[] args){
	HashSet<String> hset = new HashSet<String>();
	hset.add("Surbhi");
	hset.add("Anupam");
	hset.add("Surbhi");
	hset.add("Vipul");
	hset.add("Rahshree");
	hset.add("Ricky");

	System.out.println("Initial set : "+hset);
	hset.remove("Surbhi");
	System.out.println("After invoking remove() method : "+hset);
	AbstractSet<String> hset1 = new HashSet<String>();
	hset1.add("Sakshi");
	hset1.add("Robin");
	hset.addAll(hset1);
	System.out.println("Updated set : "+hset);
	hset.removeAll(hset1);
	System.out.println("After invoking removeAll(hset1) method : "+hset);
	hset.removeIf(str->str.contains("Vipul"));
	System.out.println("After invoking removeIf() method : "+hset);
	hset.clear();
	System.out.println("After invoking clear() method : "+hset);
	System.out.println("Hashset 1 : "+hset1);
	
    }
}
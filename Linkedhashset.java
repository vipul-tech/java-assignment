import java.util.*;

public class Linkedhashset{
    public static void main(String []args){
	LinkedHashSet<String>lhset=new LinkedHashSet<String>();
	lhset.add("one");
	lhset.add("two");
	lhset.add("three");
	lhset.add("four");
	lhset.add("five");
	lhset.add("one");
	Iterator<String>itr=lhset.iterator();
	while(itr.hasNext()){
	    System.out.println(itr.next());
	}
    }
}
import java.util.*;
public class First{
    public static void main(String []args){
	ArrayList<String> list = new ArrayList<String>();
	list.add("Vipul");
	list.add("Abhay");
	list.add("Vipul");
	list.add("Dolly");
	list.add("Surbhi");
	
	System.out.println(list.subList(1,3));
	System.out.println("Traversing list through List Iterator:");  
        ListIterator<String> list1=list.listIterator();  
        while(list1.hasNext())  
        {  
            String str=list1.next();  
            System.out.println(str);  
        }  

	Iterator itr = list.iterator();
	while(itr.hasNext()){
	    System.out.println(itr.next());
	}
	System.out.println("--------");
	for(String name : list)
	    System.out.println(name);
	System.out.println("---------");
	Collections.sort(list);
	for(int i = 0; i < list.size(); i++)
	    System.out.println(list.get(i));
	list.set(0,"Ramesh");
	Collections.sort(list);
	System.out.println("---------");
	for(int i = 0; i < list.size(); i++)
	    System.out.println(list.get(i));
	System.out.println("-----------");
	ArrayList<Integer> list2 = new ArrayList<Integer>();
	list2.add(12);
	list2.add(7);
	list2.add(98);
	list2.add(76);
	list2.add(99);
	
	Iterator itr2 = list2.iterator();
	while(itr2.hasNext()){
	    System.out.println(itr2.next());
	}
	Collections.sort(list2);
	System.out.println("--------------");
	for(int number : list2)
	    System.out.println(number);
	System.out.println("Traversing list through forEach() method:");    
        list.forEach(a->{  
            System.out.println(a);  
        });  
                
        System.out.println("Traversing list through forEachRemaining() method:");  
        Iterator<String> itr3=list.iterator();  
        itr3.forEachRemaining(a->{  
            System.out.println(a);  
        });  
    }
}
import java.util.*;

public class Test{
	public static void main(String args[]){
		ArrayList<String> al = new ArrayList<>();

		al.add("Vipul");
		al.add("Mukul");
		al.add("Roshan");
		al.add("Sonam");
		al.add("Rakesh");

		Iterator it = al.iterator();

		System.out.println(al);

		while(it.hasNext()){
			System.out.println(it.next());
		} 

		System.out.println(al.get(1));
		al.set(1,"Puja");

		Collections.sort(al); 
		for(String name:al)
			System.out.println(name);

		ArrayList<Integer> list=new ArrayList<Integer>(); 
           	list.add(12);
           	list.add(98);  
           	list.add(67);  
           	list.add(72);  
            
           	System.out.println("Traversing list through List Iterator:");  

              	ListIterator<Integer> list1=list.listIterator(list.size());  
              	while(list1.hasPrevious())  
              	{  
                	Integer str=list1.previous();  
                	System.out.println(str);  
              	}  
        	System.out.println("Traversing list through for loop:");  
           	for(int i=0;i<list.size();i++)  
           	{  
            		System.out.println(list.get(i));     
          	}  
              
        	System.out.println("Traversing list through forEach() method:");  

            	list.forEach(a->{System.out.println(a);});  
                
           	System.out.println("Traversing list through forEachRemaining() method:");  
              	Iterator<Integer> itr=list.iterator();  
              	itr.forEachRemaining(a->{System.out.println(a);});  
	}
}
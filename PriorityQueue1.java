import java.util.*;      
public class PriorityQueue1{      
 public static void main(String args[]){      
  Vector<String> v=new Vector<String>();//creating vector  
  v.add("umesh");//method of Collection  
  v.addElement("irfan");//method of Vector  
  v.addElement("kumar");  
  Enumeration e = v.elements();
  while(e.hasMoreElements())
	System.out.println(e.nextElement()); 
 }      
}      
import java.util.*;
import java.io.*;    

public class Third{
    public static void main(String[] args){
	ArrayList<String> list = new ArrayList<String>();
	list.add("Sonam");
	list.add("Sakshi");
	list.add("Ankit");
	list.add("Rakesh");
	list.add("Kunal");
	try{
	    FileOutputStream fos = new FileOutputStream("third.txt");
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    oos.writeObject(list);
	    oos.close();
	    fos.close();

	    FileInputStream fis = new FileInputStream("third.txt");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    ArrayList list2 = (ArrayList)ois.readObject();
	    System.out.println(list2);
	}
	catch(Exception e){
	    e.printStackTrace();
	}
    }
}
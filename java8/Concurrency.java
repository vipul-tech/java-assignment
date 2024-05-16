import java.util.concurrent.*;

public class Concurrency{
    public static void main(String[] args){
	Exchanger<String> ex = new Exchanger<String>();
	new MakeString(ex);
	new UseString(ex);
    }
}

class MakeString implements Runnable{
    Exchanger<String> ex;
    public MakeString(Exchanger<String> ex){
	this.ex=ex;
	new Thread(this).start();
    }

    public void run(){
	try{
	    String[] names = {"Ankit","Ramesh","Pankaj","Sonam","Sakshi"};
	    for(int i=0;i<5;i++){
		String msg = ex.exchange(names[i]);
		System.out.println("From UseString : "+msg);
		Thread.sleep(1000);
	    }
	}
	catch(Exception e){
	    System.out.println(e);
	}
    }
}

class UseString implements Runnable{
    Exchanger<String> ex;
    public UseString(Exchanger<String> ex){
	this.ex=ex;
	new Thread(this).start();
    }

    public void run(){
	try{
	    for(int i=0;i<5;i++){
		String rec = ex.exchange("Demo");
		System.out.println("Received String : "+rec);
		Thread.sleep(1000);
	    }
	}
	catch(Exception e){
	    System.out.println(e);
	}
    }
}
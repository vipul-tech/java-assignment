import java.util.concurrent.*;

public class Concurrency2{
    public static void main(String[] args) throws Exception{
	CyclicBarrier cb = new CyclicBarrier(3,new MyAction());
	System.out.println("Starting....");
	for(int i=1;i<=12;i++){
	    new MyThread(cb,"Thread "+i);
	    Thread.sleep(1000);
	}
    }
}

class MyThread implements Runnable{
    String name;
    CyclicBarrier cb;
    public MyThread(CyclicBarrier cb, String name){
	this.name=name;
	this.cb=cb;
	new Thread(this).start();
    }

    public void run(){
	try{
	    System.out.println(name);
	    cb.await();
	    System.out.println(name+" again");
	}
	catch(Exception e){
	    System.out.println(e);
	}
    }
}

class MyAction implements Runnable{
    public void run(){
	System.out.println("Finished");
    }
}
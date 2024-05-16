import java.util.concurrent.*;

public class Concurrency3{
    public static void main(String[] args) throws Exception{
	CountDownLatch cdl = new CountDownLatch(5);
	System.out.println("Starting....");
	new MyThread(cdl);
	cdl.await();
	System.out.println("Finished....");
    }
}

class MyThread implements Runnable{
    CountDownLatch cdl;
    MyThread(CountDownLatch cdl){
	this.cdl=cdl;
	new Thread(this).start();
    }
    public void run(){
	try{
	    for(int i=1;i<=10;i++){
		System.out.println(i);
		cdl.countDown();
		Thread.sleep(1000);
	    }
	}
	catch(Exception e){
	    System.out.println(e);
	}
    }
}

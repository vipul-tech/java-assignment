import java.util.concurrent.*;

public class Concurrency4{
    public static void main(String[] args){
	Phaser phsr = new Phaser(1);

	new MyThread("A",phsr);
	new MyThread("B",phsr);
	new MyThread("C",phsr);
	new MyThread("D",phsr);
	new MyThread("E",phsr);

	int currPhase = phsr.getPhase();
	phsr.arriveAndAwaitAdvance();
	System.out.println("Phase "+currPhase+" completed");

	currPhase = phsr.getPhase();
	phsr.arriveAndAwaitAdvance();
	System.out.println("Phase "+currPhase+" completed");

	currPhase = phsr.getPhase();
	phsr.arriveAndAwaitAdvance();
	System.out.println("Phase "+currPhase+" completed");
	
	phsr.arriveAndDeregister();

	if(phsr.isTerminated()){
	    System.out.println("Finished....");
	}
    }
}

class MyThread implements Runnable{
    Phaser phsr;
    String name;
    MyThread(String name, Phaser phsr){
	this.name=name;
	this.phsr=phsr;
	phsr.register();
	new Thread(this).start();
    }
    public void run(){
	System.out.println("Thread "+name+" begining phase one");
	phsr.arriveAndAwaitAdvance();
	try{
	    Thread.sleep(1000);
	}
	catch(Exception e){
	    System.out.println(e);
	}
	System.out.println("Thread "+name+" begining phase two");
	phsr.arriveAndAwaitAdvance();
	try{
	    Thread.sleep(1000);
	}
	catch(Exception e){
	    System.out.println(e);
	}
	System.out.println("Thread "+name+" begining phase three");
	phsr.arriveAndDeregister();
    }
}
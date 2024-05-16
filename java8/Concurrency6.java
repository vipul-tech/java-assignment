import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class Concurrency6{
    public static void main(String[] args){
	new MyThread();
	new MyThread();
	new MyThread();
	new MyThread();
	new MyThread();
    }
}

class Shared{
    static AtomicInteger count = new AtomicInteger(0);
}

class MyThread implements Runnable{
    MyThread(){
	new Thread(this).start();
    }
    public void run(){
	for(int i=1;i<=5;i++)
	    System.out.println(Thread.currentThread().getName()+" : "+Shared.count.getAndIncrement());
    }
}
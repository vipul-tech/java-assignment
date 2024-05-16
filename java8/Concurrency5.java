import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Concurrency5{
    public static void main(String[] args){
	ReentrantLock rl = new ReentrantLock();

	new MyThread("A",rl);
	new MyThread("B",rl);
	new MyThread("C",rl);
	new MyThread("D",rl);
	new MyThread("E",rl);

    }
}

class Shared{
    static int count=0;
}

class MyThread implements Runnable{
    ReentrantLock lock;
    String name;
    MyThread(String name, ReentrantLock lock){
	this.name=name;
	this.lock=lock;
	new Thread(this).start();
    }
    public void run(){
	System.out.println("Starting... "+name);
	lock.lock();
	System.out.println(name+" is waiting to lock the count variable");
	lock.lock();
	System.out.println(name+" has locked the count");
	Shared.count++;
	System.out.println(name+" : "+Shared.count);
	System.out.println(name+" is releasing the lock on count");
	lock.unlock();
	System.out.println("Finished... "+name);
	lock.unlock();
    }
}
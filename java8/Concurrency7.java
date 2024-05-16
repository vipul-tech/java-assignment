import java.util.concurrent.*;

public class Concurrency7{
    public static void main(String[] args) throws Exception{
	ExecutorService es = Executors.newFixedThreadPool(3);
	Future<Integer> f1 = es.submit(new Sum(10));
	Future<Integer> f2 = es.submit(new Square(5));
	Future<Double> f3 = es.submit(new Cube(3));
	es.execute(new MyThread());
	es.submit(new MyThread());

	System.out.println("Sum result : "+f1.get());
	System.out.println("Square result : "+f2.get());
	System.out.println("Cube result : "+f3.get());

	es.shutdown();
    }
}

class Sum implements Callable<Integer>{
    int value;
    Sum(int value){
	this.value=value;
    }
    public Integer call(){
	int sum = 0;
	for(int i=1;i<=value;i++)
	    sum+=i;
	return sum;
    }
}

class Square implements Callable<Integer>{
    int value;
    Square(int value){
	this.value=value;
    }
    public Integer call(){
	return value*value;
    }
}

class Cube implements Callable<Double>{
    double value;
    Cube(double value){
	this.value=value;
    }
    public Double call(){
	return value*value*value;
    }
}

class MyThread implements Runnable{
    public void run(){
	System.out.println("From MyThread class....");
    }
}
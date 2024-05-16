import java.time.LocalTime;
import java.util.concurrent.CyclicBarrier;

public class ConcurrentGame {
    public static void main(String[] args) throws Exception{
        CyclicBarrier cb = new CyclicBarrier(10, new MyAction());
        System.out.println("Bikers Ready to Go....");

        Bike b1 = new Bike(cb,"Mantu");
        Thread.sleep(500);
        Bike b2 = new Bike(cb,"Sunny");
        Thread.sleep(500);
        Bike b3 = new Bike(cb,"Don");
        Thread.sleep(500);
        Bike b4 = new Bike(cb,"Rishav");
        Thread.sleep(500);
        Bike b5 = new Bike(cb,"Monu");
        Thread.sleep(500);
        Bike b6 = new Bike(cb,"Vivek");
        Thread.sleep(500);
        Bike b7 = new Bike(cb,"Rohan");
        Thread.sleep(500);
        Bike b8 = new Bike(cb,"Praveen");
        Thread.sleep(500);
        Bike b9 = new Bike(cb,"Saurav");
        Thread.sleep(500);
        Bike b10 = new Bike(cb,"Karan");
        Thread.sleep(500);
	//cb.await();
        //System.out.println("Race Started ");
    }
}

class Bike extends Thread{
    String name;
    CyclicBarrier cb;
    public Bike(CyclicBarrier cb, String name){
        setName(name);
        this.cb = cb;
        new Thread(this).start();
    }

    public void race(){
        for (int i=1;i<20;i++){
            try {
                Thread.sleep(500);
            } 
	    catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Biker : "+getName());
        }
    }

    public void run() {
        try{
            System.out.println("Biker : "+ getName() +" Ready to go");
            cb.await();                                             
            LocalTime d1 = LocalTime.now();
            System.out.println("Biker "+getName() +" started at "+d1);
            race();
            LocalTime d2 = LocalTime.now();
            System.out.println("Biker "+getName() +" finished at "+d2);
        }
	catch (Exception e){
            System.out.println(e);
        }
	//try{cb.await();}catch(Exception e){System.out.println(e);}
	//System.out.println("Race finished...");
    }
}

class MyAction implements Runnable{
    public void run() {
        System.out.println("Race started....");
    }
}
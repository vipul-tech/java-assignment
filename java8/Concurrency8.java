import java.util.concurrent.*;

public class Concurrency8{
    public static void main(String[] args){
	int processors = Runtime.getRuntime().availableProcessors();
	//System.out.println(processors);
	int[] numbers = new int[1000];
	for(int i=0;i<numbers.length;i++)
	    numbers[i]=i;
	ForkJoinPool forkjoinpool = new ForkJoinPool(processors);
	Long result = forkjoinpool.invoke(new Sum(numbers,0,numbers.length));
	System.out.println(result);
    }
}

class Sum extends RecursiveTask<Long>{
    int low;
    int high;
    int[] array;
    Sum(int[] array, int low, int high){
	this.array=array;
	this.low=low;
	this.high=high;
    }
    protected Long compute(){
	if(high-low<=10){
	    long sum=0;
	    for(int i=low;i<high;++i)
		sum+=array[i];
	    return sum;
	}
	else{
	    int mid = low + (high-low)/2;
	    Sum left = new Sum(array,low,mid);
	    Sum right = new Sum(array,mid,high);
	    left.fork();
	    long rightResult = right.compute();
	    long leftResult = left.join();
	    return leftResult+rightResult;
	}
    }
}
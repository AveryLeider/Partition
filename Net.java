import java.util.*;
import java.util.concurrent.TimeUnit;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;

public class Net {

	public static void partition(int n)

	{

		partition(n,n,"");

	}

	public static void partition(int n,int max,String prefix)

	{
		

		if(n==0)

		{

		//	System.out.println(prefix);

		}

		for(int i= Math.min(max, n);i>=1;i--)

		{

			partition(n-i,i,prefix+""+i);

		}

	}

	public static void main(String[] args) {
		if(args.length == 0) { 
			System.out.println("Usage: java net [integer to partition]");
			return; 
		}
		long startTime = System.nanoTime();
		partition(Integer.parseInt(args[0]));
                long stopTime = System.nanoTime();

   		long elapsedTime=stopTime-startTime;
   		System.out.println(elapsedTime + " nanoseconds");
   		//System.out.println("Time Complexity is "+elapsedTime+"  nanoseconds !");
		//System.out.println("Time Complexity is "+TimeUnit.NANOSECONDS.toMillis(elapsedTime)+"  milliseconds !");
		//ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
		//System.out.println("Thread count: " + threadBean.getThreadCount());
		//System.out.println("Thread Time Complexity " + TimeUnit.NANOSECONDS.toMillis(threadBean.getCurrentThreadCpuTime()) + " ms");
	}

}

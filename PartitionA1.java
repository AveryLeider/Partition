import java.util.*;
import java.util.concurrent.TimeUnit;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;
class PartitionA1
{ 
 static int[] prefix=new int[6];
 static int pass=0;
 static int stop=0;
 static int first=0;
 public static void main(String[] args)
 {
   long startTime = System.currentTimeMillis();
   Partition(6,4);
   long stopTime = System.currentTimeMillis();
   long elapsedTime=stopTime-startTime;
   System.out.println(" ");
   System.out.println("Time Complexity is "+elapsedTime+"  milliseconds !");
   MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
   ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
   System.out.println(String.format("Heap: Init: %d, Used: %d, Committed: %d, Max: %d", memBean.getHeapMemoryUsage().getInit(), memBean.getHeapMemoryUsage().getUsed(), memBean.getHeapMemoryUsage().getCommitted(), memBean.getHeapMemoryUsage().getMax()));
   System.out.println("Thread Time Complexity" + TimeUnit.NANOSECONDS.toMillis(threadBean.getCurrentThreadCpuTime()) + " ms");
   }
   static void  Partition(int n,int k)
   {
      int i;
      if(k>n)    
       {
          first=1;
          if(pass-2>=0)
          pass=pass-2;
          else pass=pass-1;
          stop=0;
          System.out.println("\n");
        }
     else if(k==1)
         { 
            System.out.println(n);
            if(n >1)
	  { for(int j=0;j<pass-1;j++)
	     System.out.print(prefix[j]+",");
            	   }
                  stop=1;
           }
       else
           {
                for(i=1;i<=n;i++)
	     {

                             if(first==1&& (n-i)>=(k-1) )
                              {
                              first =0;
	             for(int z=0;z<pass;z++)
                              System.out.print(prefix[z]+",");
                              }
	            if(k>1 && stop==0) 
		  {
		    prefix[pass]=i;
		    pass++;
		   }
                             
                             if(i<n && (n-i)>=(k-1))
	            System.out.print(i+",");

	   
	Partition(n-i,k-1);  
	   }
	}  
	}}
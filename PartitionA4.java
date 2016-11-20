import java.util.*;
import java.util.concurrent.TimeUnit;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;
class PartitionA4
{ 
 static int[] prefix=new int[6];//prefix[] used to store prefix values 
 static int pass=0;// pass used to store values in prefix array
 static int stop=0; //flag to stop increasing pass value
 static int first=0; //similar to pass, for the first of the list
 static int factorial=0; //we might need it.

 public static void main(String[] args)
   { 		//begin main method
long startTime = System.nanoTime();
   Partition(6,4,3);
   long stopTime = System.nanoTime();
   long elapsedTime=stopTime-startTime;
   System.out.println(" ");
   System.out.println("Time Complexity is "+elapsedTime+"  nanoseconds !");
   System.out.println("Time Complexity is "+TimeUnit.NANOSECONDS.toMillis(elapsedTime)+"  milliseconds !");
   ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
   System.out.println("Thread count: " + threadBean.getThreadCount());
   System.out.println("Thread Time Complexity " + TimeUnit.NANOSECONDS.toMillis(threadBean.getCurrentThreadCpuTime()) + " ms");
   }  		//end main method
   static void  Partition(int n,int k, int s)
   { 		//begin Partition method
      int i;
      if(k>n)              // if k > n  
       {
          first=1;
          if(pass-2>=0)
          pass=pass-2;
          else pass=pass-1;
          stop=0;
          System.out.println("\n");
        }
     else if(k==1)      // if k == 1
         {
             factorial++;
             if(factorial==6)
               {
                  pass--;
                  factorial=factorial-3; //can that be s ?
                }
             System.out.println(n);
             if((n-1)==1 || k>1)
                { 
                   stop=1;
                      for(int j=0;j<pass-1;j++)
	     System.out.print(prefix[j]+",");
            	   }
              else
                 {
                  stop=0;
                  first=1;
                   System.out.print("\n");
                if(pass-2 >=0)
                
                pass=pass-2;
               else
               pass=pass-1;
                   }
                
           }
       else
           {
                int ceil=n%k==0?0:1;
                
                for(i=n/k+ceil;i<=s;i++)
	     {
                             
                             if(first==1 )
                              {
                              first =0;
	             for(int z=0;z<pass;z++)
                              System.out.print(prefix[z]+",");
                              }
	            if(s>1 && stop==0) 
		  {
		    prefix[pass]=i;
		    pass++;
		   }
                             
                             if(i<n && (n-i)>=(k-1))
	            System.out.print(i+",");
                               
               Partition(n-i,k-1,Math.min(i, n-i-k+2));  
                 }
             }  
        }
    }//end Partition method
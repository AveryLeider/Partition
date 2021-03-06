import java.util.*;
import java.util.concurrent.TimeUnit;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;
class PartitionA2
{ 
 static int[] prefix=new int[6];
 static int pass=0;
 static int stop=0;
 static int first=0;
 static int factorial=0;

 public static void main(String[] args)
 {
   long startTime = System.nanoTime();
   Partition(6,4);
   long stopTime = System.nanoTime();
   long elapsedTime=stopTime-startTime;
   System.out.println(" ");
   System.out.println("Time Complexity is "+elapsedTime+"  nanoseconds !");
   System.out.println("Time Complexity is "+TimeUnit.NANOSECONDS.toMillis(elapsedTime)+"  milliseconds !");
   ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
   System.out.println("Thread count: " + threadBean.getThreadCount());
   System.out.println("Thread Time Complexity " + TimeUnit.NANOSECONDS.toMillis(threadBean.getCurrentThreadCpuTime()) + " ms");
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
             factorial++;
            if(factorial==6)
             {
             pass--;
              factorial=factorial-3;
              }
        
            
            System.out.println(n);
            if(n >1)
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
                for(i=1;i<=(n-k)+1;i++)
	     {
                         
                             if(first==1 )
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
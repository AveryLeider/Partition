import java.util.*;
public class Net {

	public static void partition(int n)

	{

		partition(n,n,"");

	}

	public static void partition(int n,int max,String prefix)

	{
		

		if(n==0)

		{

			System.out.println(prefix);

		}

		for(int i= Math.min(max, n);i>=1;i--)

		{

			partition(n-i,i,prefix+""+i);

		}

	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int n;
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the value of n");
		n = scan.nextInt();

		partition(n);
                                    long stopTime = System.currentTimeMillis();
   		long elapsedTime=stopTime-startTime;
   		System.out.println(" ");
   		System.out.println("Time Complexity is "+elapsedTime+"  milliseconds !");
	}

}
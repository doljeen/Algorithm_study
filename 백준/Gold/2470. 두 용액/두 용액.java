import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0; i<n; i++)
		{
			long num =sc.nextLong();
			arr[i] = num;
		}
		Arrays.sort(arr);
		long target1 = 10000000000L;
		long target2 = 10000000000L;
		long distance = 10000000000L;
		int s = 0, e = n-1;
		while(true)
		{
			if(s==e)
			{
				break;
			}
			long temp = arr[s]+arr[e];
			if(temp < 0)
			{
				if(Math.abs(temp) < distance)
				{
					distance = Math.abs(temp);
					target1 = arr[s];
					target2 = arr[e];
				}
				s++;
			}
			else if(temp == 0)
			{
				distance  = 0;
				target1 = arr[s];
				target2 = arr[e];
				break;
			}
			else
			{
				if(Math.abs(temp) < distance)
				{
					distance = Math.abs(temp);
					target1 = arr[s];
					target2 = arr[e];
				}
				e--;
			}
			
		}
		System.out.println(target1+" " + target2);
		
		
	}

}

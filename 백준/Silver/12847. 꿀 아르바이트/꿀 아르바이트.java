import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		long []sum = new long[n+1];
		for(int i=1; i<=n; i++)
		{
			int work = sc.nextInt();
			sum[i] = work+sum[i-1];
		}
		long max = 0;
		for(int i=m; i<=n; i++)
		{
			long now = sum[i]-sum[i-m];
			if(now>max)
			{
				max = now;
			}
		}
		System.out.println(max);
		
	}

}

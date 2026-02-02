import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		long []sum = new long[n+1];
		for(int i=1; i<=n; i++)
		{
			long work = sc.nextInt();
			sum[i] = work+sum[i-1];
		}
		for(int k=1; k<=m ; k++)
		{
			int  i = sc.nextInt();
			int j = sc.nextInt();
			System.out.println(sum[j]- sum[i-1]);
			
		}
		
	}

}

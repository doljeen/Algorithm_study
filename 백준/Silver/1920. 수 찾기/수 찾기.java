import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 전체 숫자 개수
		int n = sc.nextInt();
		// 2^31승이면 10^9승 넘어가니까.. 범위 크게..
		long a[] = new long[n];
		
		for(int i=0; i<n ; i++)
		{
			a[i] = sc.nextInt();
		}
		// 찾아야 하는 수의 개수
		int fn = sc.nextInt();
		// 찾아야 하는 수
		long f[] = new long[fn];


		for(int i=0; i<fn; i++)
		{
			f[i] = sc.nextInt();
		}
		Arrays.sort(a);

		for(int k=0; k<fn; k++)
		{
			int i=0; 
			int j=a.length-1;
			int isfind = 0;
			while(i<=j)
			{
				int mid = (i+j)/2;
				if(a[mid] == f[k])
				{
					System.out.println(1);
					isfind = 1;
					break;
				}
				if(a[mid] <f[k])
				{
					i = mid+1;
				}
				if(a[mid] > f[k])
				{
					j= mid-1;
				}
				
			}
			if(isfind == 0)
			{
				System.out.println(0);
			}
		}
	
		
	}
}

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)throws Exception {
		
		Scanner sc= new Scanner(System.in);
		int n =sc.nextInt();
		int m =sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++)
		{
			int num = sc.nextInt();
			arr[i] = num ; 
		}
		Arrays.sort(arr);
		int s= 0, e=n-1;
		int count = 0;
		while(true)
		{
			if(s>=e)
			{
				break;
			}
			else
			{
				int temp = arr[s]+arr[e];
				if(temp < m)
				{
					s++;
				}
				else if(temp == m)
				{
					count++;
					s++;
					e--;
				}
				else
				{
					e--;
				}
			}
		}
		System.out.println(count);
	}

}

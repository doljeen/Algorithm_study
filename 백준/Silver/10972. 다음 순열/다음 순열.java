import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		
		for(int i=0; i<n; i++)
		{
			a[i] = sc.nextInt();
		}
		
		// 절벽 바로 아래 찾기
		int i = n-1;
		while((i-1>=0) && (a[i-1]>=a[i])) i--;
		
		if(i-1 <0)
		{
			System.out.println(-1);
			return;
		}
		// 현재 i-1(절벽 바로 아래)보다 큰 부분 다시 찾기
		int j = n-1;
		while((i-1>=0) && (a[i-1]>a[j])) j--;
		
		// i-1, j 바꿔주기
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j]= temp;
		
		// i 뒤는 다시 정렬
		int k = n-1;
		while(i<=k)
		{
			int tmp = a[i];
			a[i] = a[k];
			a[k]= tmp;
			i++;
			k--;
		}
		for(int x : a)
		{
			System.out.printf("%d ",x);
		}
		
	}
}

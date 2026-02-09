import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a[] = new int[n];
		
		for(int i=0; i<n; i++)
		{
			a[i] = sc.nextInt();
		}
		
		int i = n-1;
		while((i-1>=0) && (a[i-1] <= a[i])) i--;
		if(i-1 <0)
		{
			System.out.println(-1);
			return;
		}
		int j = n-1;
		while((i-1>=0) && (a[i-1]<=a[j])) j--;
		int temp = a[i-1];
		a[i-1] = a[j];
		a[j] = temp;
		
		int k = n-1;
		while(i<k)
		{
			temp = a[i];
			a[i] = a[k];
			a[k] = temp;
			i++;
			k--;
		}
		for(int q=0; q<n; q++)
		{
			System.out.printf("%d ", a[q]);
		}
	}

}

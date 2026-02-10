import java.util.Arrays;
import java.util.Scanner;

public class Main {

	
	static int n;
	static int[] w;
	static int[] h;
	static int[] d;
	static int[] rd;
	static int total;

	static void put(int cnt)
	{
		if(cnt == n)
		{
			total++;
			return;
		}
		for(int i=0; i<n; i++)
		{
			if(h[i] == 1 || d[cnt+i] == 1 || rd[n-(cnt-i)] ==1) continue;
			h[i] = d[cnt+i] = rd[n-(cnt-i)] = 1;
			put(cnt+1);
			h[i] = d[cnt+i] = rd[n-(cnt-i)] = 0;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt();
		w = new int[n];
		h = new int[n];
		d = new int[2*n];
		rd = new int[2*n];
		put(0);
		System.out.println(total);
	}

}

import java.util.Scanner;

public class Main {

	static int m[][];
	static int n;
	static int bcnt;
	static int wcnt;
	
	static void cut(int startx, int starty, int size)
	{
		int wsum = 0;
		for(int i=startx; i < startx+size; i++)
		{
			for(int j=starty; j <starty+size; j++)
			{
				if(m[i][j] == 0)
				{
					wsum++;
				}
			}
		}
		
		if(wsum == size*size)
		{
			wcnt++;
			return;
		}
		
		if(wsum == 0)
		{
			bcnt++;
			return;
		}
		cut(startx,starty,size/2);
		cut(startx,starty+size/2, size/2);
		cut(startx+size/2,starty, size/2);
		cut(startx+size/2,starty+size/2, size/2);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m= new int[n][n];
		
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				m[i][j] = sc.nextInt();
			}
		}
		
		cut(0,0,n);
		System.out.println(wcnt);
		System.out.println(bcnt);
	}
	

}

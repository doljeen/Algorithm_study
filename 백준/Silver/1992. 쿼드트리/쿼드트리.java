import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static char[][] m;
	
	static void cut(int startx, int starty,int size)
	{
		int zero = 0;
		for(int i=startx; i<startx+size; i++)
		{
			for(int j=starty; j<starty+size;j++)
			{
				if(m[i][j] == '0')
				{
					zero++;
				}
			}
		}
		if(zero == size*size)
		{
			System.out.print(0);
			return;
		}
		if(zero == 0)
		{
			System.out.print(1);
			return;
		}
		int half = size/2;
		System.out.print("(");
		cut(startx, starty, half);
		cut(startx, starty+half, half);
		cut(startx+half, starty, half);
		cut(startx+half, starty+half, half);
		System.out.print(")");

		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 한변 길이
		int n= sc.nextInt();
		sc.nextLine();
		// 0,1 숫자 표시 맵
		m = new char[n][n];

		for(int i=0; i<n; i++)
		{
			String line = sc.nextLine();
			for(int j=0; j<line.length();j++)
			{
				m[i][j] = line.charAt(j);
			}
		}
		cut(0, 0, n);
	}

}

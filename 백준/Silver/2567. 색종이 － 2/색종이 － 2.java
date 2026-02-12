import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m[][] = new int[102][102];
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		int cnt = 0;
		for(int i=0; i<n ; i++)
		{
			int x, y;
			x = sc.nextInt();
			y = sc.nextInt();
			
			for(int j=x+1; j<x+1+10; j++)
			{
				for(int k=y+1; k<y+1+10; k++)
				{
					m[j][k] = 1;
				}
			}
		}
		for(int i=1; i<101; i++)
		{
			for(int j=1; j<101; j++)
			{
				
				if(m[i][j] ==1)
				{
					for(int k=0; k<4; k++)
					{
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx>=0 && ny>=0 && nx<=101 && ny<=101)
						{
							if(m[nx][ny] ==0)
							{
								cnt++;
							}

						}

					}
				}
				

			}
		}
		System.out.println(cnt);
	}

}

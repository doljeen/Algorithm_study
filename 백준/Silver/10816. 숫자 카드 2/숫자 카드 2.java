import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		// 전체 카드 개수
		int n = sc.nextInt();
		// 카드 받기
		int c[] = new int[n];
		
		for(int i=0; i<n; i++)
		{
			c[i] = sc.nextInt();
		}
		//이진 탐색 정렬
		Arrays.sort(c);
		// 몇 개인지 세어야할 수의 개수
		int m = sc.nextInt();

		for(int k=0; k<m ; k++)
		{
			// 몇개인지 찾아야할 숫자
			int f = sc.nextInt();
			int li=0;
			int lj=c.length;
			int ui=0;
			int uj=c.length;
			
			while(li<lj)
			{
				int mid = (li+lj)/2;
				if(c[mid] < f)
				{
					li = mid+1;
				}
				else if(c[mid]>= f)
				{
					lj = mid;
				}
			}
		
			while(ui<uj)
			{
				int mid = (ui+uj)/2;
				if(c[mid] <= f)
				{
					ui = mid+1;
				}
				else if(c[mid]> f)
				{
					uj = mid;
				}
			}
			
			sb.append(ui-li).append(" ");
			
		}
		System.out.println(sb);
		
		
	}

}

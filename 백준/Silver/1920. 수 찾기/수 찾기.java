import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 전체 숫자 개수
		int n = sc.nextInt();
		// 2^31승이면 10^9승 넘어가니까.. 범위 크게..
		HashMap<String, Integer> hmap =new HashMap<>();
		
		for(int i=0; i<n ; i++)
		{
			String tmp = sc.next();
			hmap.put(tmp, 1);
		}
		// 찾아야 하는 수의 개수
		int fn = sc.nextInt();


		for(int i=0; i<fn; i++)
		{
			String find = sc.next();
			if(hmap.containsKey(find))
			{
				System.out.println(1);
			}
			else
			{
				System.out.println(0);
			}
		}
	}

}

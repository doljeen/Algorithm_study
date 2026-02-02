import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			List<Integer> actArr = new LinkedList<>();
			for(int i =0; i < N; i++) {
				actArr.add(sc.nextInt());
			}
			int C = sc.nextInt();
			for(int i = 0; i < C; i++) {
				String a = sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				for(int j = 0; j < y; j++) {
					actArr.add(x++, sc.nextInt());
				}
			}
			
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < 10; i++) {
				System.out.print(actArr.get(i) + " ");
			}
			System.out.println();
		}

	}

}

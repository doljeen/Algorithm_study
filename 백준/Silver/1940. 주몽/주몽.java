import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int s = 0;
		int e = N-1;

		Arrays.sort(arr);
		
		int ans = 0;
		
		while(s<e) {
			// 두 포인터가 가리키는 값을 더함
			int sum = arr[s] + arr[e];
			if(sum == M) { // 더한 값이 목표값과 동일
				ans++;
				s++;
				e--;
			}else if(sum < M) { // 더한 값이 목표값보다 작다 -> 값을 크게 만들자
				s++;
			}else { // 더한 값이 목표값보다 크다 -> 값을 작게 만들자
				e--;
			}
		}
		
		System.out.println(ans);
	}
}

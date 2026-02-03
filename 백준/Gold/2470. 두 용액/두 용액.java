import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int s = 0;
		int e = N-1;
		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		Arrays.sort(arr);
		while(s<e) {
			long sum = arr[s] + arr[e];
			if(min > Math.abs(arr[s] + arr[e])) {
				left = s;
				right = e;
				min = Math.abs(arr[s] + arr[e]);
			}else if(sum < min) {
				s++;
			}else {
				e--;
			}
		}
		
		System.out.println(arr[left] + " " + arr[right]);
	}
}

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int start = 0;
		int cnt = 0;
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i = 0; i < N; i++) {
			if(arr[i] <= L) {
				L++;
			}else {
				break;
			}
		}
		System.out.println(L);
	}

}

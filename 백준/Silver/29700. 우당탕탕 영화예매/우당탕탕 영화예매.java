import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		char[][] Carr = new char[N][M];
		int[][] arr = new int[N][M];
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			Carr[i] = str.toCharArray();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = Carr[i][j] - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			int left = 0;
			int right = K;
			int sum = 0;
			if(M < K) {
				break;
			}
			for(int j = 0; j<K; j++) {
				sum += arr[i][j];
			}
			if(sum == 0) {
				cnt++;
			}
			while(right < M) {
				sum -= arr[i][left++];
				sum += arr[i][right++];
				if(sum == 0) cnt++;
			}
		}
		System.out.println(cnt);
		
	}
}
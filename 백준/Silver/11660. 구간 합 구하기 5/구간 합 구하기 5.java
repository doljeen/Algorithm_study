
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N+1][N+1];
		int[][] sum = new int[N+1][N+1];
		int temp = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				arr[i][j] = sc.nextInt();
				temp = arr[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
				sum[i][j] = temp;
			}
		}
		for(int i = 0; i < M; i++) {
			int result = 0;
			int startR = sc.nextInt();
			int startC = sc.nextInt();
			int endR = sc.nextInt();
			int endC = sc.nextInt();
			result = sum[endR][endC] - sum[endR][startC-1] - sum[startR-1][endC] + sum[startR-1][startC-1];
			
			System.out.println(result);
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, B;
	static int[] arr;
	static int bestSum;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr = new int[N];
			bestSum = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			bestTop(0, 0);
			System.out.println("#" + test_case + " " + bestSum);
		}
	}
	public static void bestTop(int cnt, int sum) {
		if(cnt == N) {
			int minus = sum - B;
			if(minus >= 0) {
				bestSum = Math.min(bestSum, minus);
			}
			return;
		}
		bestTop(cnt+1, sum + arr[cnt]);
		bestTop(cnt+1, sum);
	}
}

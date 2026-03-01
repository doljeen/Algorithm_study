import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	public static int N;
	public static int[][] arr;
	
	static int [] dr = {-1, 1, 0 ,0};
	static int [] dc = {0, 0,-1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			
			int [][] dp = new int [N][N];
			for (int i=0;i<N;i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
			dp[0][0] = 0;
			
			PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparing(a->a[2]));
			pq.add(new int [] {0, 0, 0});
			
			while (!pq.isEmpty()) {
				int [] cur = pq.poll();
				
				if (cur[0] == N-1 && cur[1] == N-1) break; 
				if (cur[2] > dp[cur[0]][cur[1]]) continue;
				for (int i=0;i<4;i++) {
					int nextR = cur[0] + dr[i];
					int nextC = cur[1] + dc[i];
					if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
					
					if (cur[2] + arr[nextR][nextC] < dp[nextR][nextC]) {
						dp[nextR][nextC] = cur[2] + arr[nextR][nextC];
						pq.add(new int [] {nextR, nextC, dp[nextR][nextC]});
					}
				}
			}
			System.out.println("#" + tc + " " + dp[N-1][N-1]);
		}
	}
}

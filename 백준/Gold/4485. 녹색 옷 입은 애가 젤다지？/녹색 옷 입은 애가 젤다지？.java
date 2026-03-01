import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, -0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			tc++;
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp = new int[N][N];
			for(int i = 0; i < N; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);				
			}
			dp[0][0] = arr[0][0];
			PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(a->a[2]));
			queue.add(new int[] {0, 0, dp[0][0]});
			
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				if(cur[0] >= N && cur[1] >= N) break;
				for(int i = 0; i < 4; i++) {
					int nr = cur[0] + dx[i];
					int nc = cur[1] + dy[i];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					if(cur[2] + arr[nr][nc] < dp[nr][nc]) {
						dp[nr][nc] = cur[2] + arr[nr][nc];
						queue.add(new int[] {nr, nc, dp[nr][nc]});
					}
				}
			}
			System.out.println("Problem " + tc + ": " + dp[N-1][N-1]);
		}
	}

}

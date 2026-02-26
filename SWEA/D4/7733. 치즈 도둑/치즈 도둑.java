
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static int N, result;
	public static int[][] arr;
	public static boolean[][] visited;
	public static boolean[][] copy;
	public static int dx[] = {1, -1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			copy = new boolean[N][N];
			result = 1;
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int d = 0; d <= N; d++) {
				int cnt = 0;
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(arr[i][j] == d+1) {
							visited[i][j] = true;
						}
					}
				}
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						copy[i][j] = visited[i][j];
					}
				}
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(!copy[i][j]) {
							cnt++;
							bfs(i, j);
						}
					}
				}
				if(result < cnt) result = cnt;
			}
			System.out.println("#" + tc + " " + result);
		}
	}
	private static void bfs(int row, int col) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {row, col});
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int curR = current[0];
			int curC = current[1];
			for(int i = 0; i < 4; i++) {
				int nr = curR + dx[i];
				int nc = curC + dy[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || copy[nr][nc]) continue;
				copy[nr][nc] = true;
				queue.add(new int[] {nr, nc});
			}
		}
	}
}

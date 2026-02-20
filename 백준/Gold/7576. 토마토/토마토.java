import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, result;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static Queue<int[]> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		queue = new ArrayDeque<>();
		visited = new boolean[N][M];
		result = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					queue.offer(new int[] {i, j, 0});
					visited[i][j] = true;
				}
				if(arr[i][j] == -1) {
					visited[i][j] = true;
				}
			}
		}
		bfs();
		S:for(int i =0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					result = -1;
					break S;
				}
			}
		}
		System.out.println(result);
	}
	
	private static void bfs() {
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int curR = current[0];
			int curC = current[1];
			int state = current[2];
			for(int i = 0; i < 4; i++) {
				int nr = curR + dy[i];
				int nc = curC + dx[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				queue.offer(new int[] {nr, nc, state+1});
			}
			result = state;
		}
	}

}

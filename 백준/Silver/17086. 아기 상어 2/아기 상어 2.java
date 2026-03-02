import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[][] map;
	public static int[] dx = {0, 0, -1, 1, 1, -1, 1, -1};
	public static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int max= 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					int tmp = bfs(i, j);
					if(max < tmp) max = tmp;					
				}
			}
		}
		System.out.println(max);
	}
	
	public static int bfs(int row, int col) {
		int result = 0;
		boolean[][] visited = new boolean[N][M];
		visited[row][col] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {row, col, 0});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curR = cur[0];
			int curC = cur[1];
			int depth = cur[2];
			for(int i = 0; i < 8; i++) {
				int nr = curR + dx[i];
				int nc = curC + dy[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
				if(map[nr][nc] == 1) return depth+1;
				queue.add(new int[] {nr, nc, depth+1});
				visited[nr][nc] = true;
				
			}
		}
		return result;
	}

}

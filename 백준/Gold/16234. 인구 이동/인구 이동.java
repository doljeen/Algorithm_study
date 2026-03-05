import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, L, R;
	public static int[][] arr;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		while(true) {			
			boolean state = false;
			boolean[][] visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						int tmp = bfs(i, j, visited);
						if(tmp == 1) {
							state = true;
						}
					}
				}
			}
			if(!state) break;
			cnt++;
		}
		System.out.println(cnt);
		
	}
	public static int bfs(int row, int col, boolean[][] visited) {
		Queue<int[]> queue = new ArrayDeque<>();
		Queue<int[]> result = new ArrayDeque<>();
		visited[row][col] = true;
		queue.add(new int[] {row, col});
		result.add(new int[] {row, col});
		int sum = arr[row][col];
		int cnt = 1;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curR = cur[0];
			int curC = cur[1];
			for(int i = 0; i < 4; i++) {
				int nr = curR + dx[i];
				int nc = curC + dy[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
				int minus = Math.abs(arr[curR][curC]-arr[nr][nc]);
				if(minus >= L && minus <= R) {
					visited[nr][nc] = true;
					sum += arr[nr][nc];
					cnt++;
					result.add(new int[] {nr, nc});
					queue.add(new int[] {nr, nc});
				}
			}			
		}
		if(cnt > 1) {
			int tmp = sum / cnt;
			while(!result.isEmpty()) {
				int[] cur = result.poll();
				arr[cur[0]][cur[1]] = tmp;
			}
			return 1;
		}else {
			return 0;
		}
	}
}

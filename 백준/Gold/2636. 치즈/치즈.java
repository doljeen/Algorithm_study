
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, cnt;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		cnt = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			int stop = 0;
			visited = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] == 1) {
						stop++;
					}
				}
			}
			if(stop == 0) break;
			int tmp = bfs();
			cnt++;
			if(min > tmp)min = tmp;
		}
		System.out.println(cnt);
		System.out.println(min);
	}
	
	public static int bfs() {
		int result = 0;
		visited[0][0] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0,0});
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int curR = current[0];
			int curC = current[1];
			for(int i = 0; i < 4; i++) {
				int nr = curR + dx[i];
				int nc = curC + dy[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
				if(arr[nr][nc] == 1) {
					visited[nr][nc] = true;
					arr[nr][nc] = 0;
					result++;
				} else {
					queue.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
				
			}
		}
		if(result > 0) {
			return result;			
		}else {
			return Integer.MAX_VALUE;
		}
	}
}

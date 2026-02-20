
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int w, h;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};
	public static int[] dy = {1, 0, -1, 0, 1, 1, -1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) break;
			arr = new int[h][w];
			visited = new boolean[h][w];
			int count = 0;
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(arr[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	private static void bfs(int row, int col) {
		Queue<int[]> queue = new ArrayDeque<>();
		visited[row][col] = true;
		queue.offer(new int[] {row, col});
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int curR = current[0];
			int curC = current[1];
			for(int i = 0; i < 8; i++) {
				int nr = curR + dy[i];
				int nc = curC + dx[i];
				if(nr < 0 || nr >= h || nc < 0 || nc >= w || visited[nr][nc] || arr[nr][nc] == 0) continue;
				queue.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
	}

}

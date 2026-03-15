import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int K, W, H;
	public static int[][] map;
	public static boolean[][][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int[] ddx = {-1, -2, -1, -2, 1, 2, 1, 2};
	public static int[] ddy = {2, 1, -2, -1, 2, 1, -2, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = bfs();
		System.out.println(result);
	}
	
	public static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0, 0, 0, K});
		visited[0][0][K] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curR = cur[0];
			int curC = cur[1];
			int dist = cur[2];
			int state = cur[3];
			if(curR == H-1 && curC == W-1) return dist;
			for(int i = 0; i < 4; i++) {
				int nr = curR + dx[i];
				int nc = curC + dy[i];
				if(nr < 0 || nr >= H || nc < 0 || nc >=W || visited[nr][nc][state]) continue;
				if(map[nr][nc] == 1) continue;
				else {
					visited[nr][nc][state] = true;
					queue.add(new int[] {nr, nc, dist+1, state});
				}
			}
			if(state > 0) {
				for(int k = 0; k < 8; k++) {
					int nnr = curR + ddx[k];
					int nnc = curC + ddy[k];
					if(nnr < 0 || nnr >= H || nnc < 0 || nnc >= W || visited[nnr][nnc][state-1] || map[nnr][nnc] == 1) continue;
					visited[nnr][nnc][state-1] = true;
					queue.add(new int[] {nnr, nnc, dist+1, state-1});
				}
			} 
			
				
		}
		return -1;
	}

}

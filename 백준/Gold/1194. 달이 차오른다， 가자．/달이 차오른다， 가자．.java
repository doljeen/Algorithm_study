import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static char[][] map;
	public static boolean[][][] visited;
	public static int[] valuekey;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		valuekey = new int[6];
		visited = new boolean[N][M][64];
		int row = 0;
		int col = 0;
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
			for(int j = 0; j < M; j++) {
				if(map[i][j] == '#') visited[i][j][0] = true;
				if(map[i][j] == '0') {
					row = i;
					col = j;
				}
			}
		}
		
		
		System.out.println(bfs(row, col));
	}
	
	public static int bfs(int row, int col) {
		Queue<Pos> queue = new ArrayDeque<>();
		queue.add(new Pos(row, col, 0, 0));
		
		visited[row][col][0] = true;
		while(!queue.isEmpty()) {
			Pos cur = queue.poll();
			int curR = cur.row;
			int curC = cur.col;
			int dist = cur.dist;
			int keyset = cur.keybit;
			for(int i = 0; i < 4; i++) {
				int nr = curR + dx[i];
				int nc = curC + dy[i];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#') continue;
				int nextkey = keyset;
				if(map[nr][nc] == '1') return dist + 1;
				if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
					if((keyset & (1 << (map[nr][nc] - 'A'))) == 0) continue;
				}
				if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f'){
					nextkey |= (1 << (map[nr][nc]-'a'));
				}
				if(!visited[nr][nc][nextkey]) {
					visited[nr][nc][nextkey] = true;
					queue.add(new Pos(nr, nc, nextkey, dist+1));					
				}
				
			}
		}
		return -1;
	}
	static class Pos{
		int row, col, keybit, dist;

		public Pos(int row, int col, int keybit, int dist) {
			super();
			this.row = row;
			this.col = col;
			this.keybit = keybit;
			this.dist = dist;
		}
		
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int h, w;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};
	public static int[] dy = {1, 0, -1, 0, 1, 1, -1, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			arr = new int[w][h];
			visited = new boolean[w][h];
			int count = 0;
			if(h == 0 && w == 0) break;
			for(int i = 0; i < w; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < h; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < w; i++) {
				for(int j = 0; j < h; j++) {
					if(arr[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	public static void dfs(int row, int col) {
		visited[row][col] = true;
		for(int i = 0; i < 8; i++) {
			int nr = row+dx[i];
			int nc = col+dy[i];
			if(nr >= w || nc >= h || nr < 0 || nc < 0 || visited[nr][nc] || arr[nr][nc] == 0) continue;
			dfs(nr, nc);
		}
	}
}

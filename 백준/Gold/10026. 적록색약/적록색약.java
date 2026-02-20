
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static int N;
	public static char[][] arr;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			arr[i] = str.toCharArray();
		}
		int disable = 0;
		int general = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i, j, arr[i][j], false);
					disable++;
				}
			}
		}
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i, j, arr[i][j], true);
					general++;
				}
			}
		}
		
		System.out.println(general + " " + disable);
	}
	
	public static void bfs(int row, int col, char color, boolean state) {
		Queue<int[]> queue = new ArrayDeque<>();
		visited[row][col] = true;
		queue.offer(new int[] {row, col});
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int curR = current[0];
			int curC = current[1];
			for(int i = 0; i < 4; i++) {
				int nR = curR + dy[i];
				int nC = curC + dx[i];
				if(nR < 0 || nC < 0 || nR >= N || nC >= N || visited[nR][nC]) continue;
				if(state == false) {
					if(color == 'B') {
						if(arr[nR][nC] == color) {
							visited[nR][nC] = true;
							queue.offer(new int[] {nR, nC});
						}
					}
					else {
						if(arr[nR][nC] == 'R' || arr[nR][nC] == 'G') {
							queue.offer(new int[] {nR, nC});
							visited[nR][nC] = true;
						}
					}
				}
				else {
					if(arr[nR][nC] == color) {
						queue.offer(new int[] {nR, nC});
						visited[nR][nC] = true;
					}
				}
			}
		}
	}

}

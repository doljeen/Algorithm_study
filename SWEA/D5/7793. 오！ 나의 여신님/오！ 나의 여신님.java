import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static int N, M;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static List<Integer> DevRow;
	public static List<Integer> DevCol;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visited = new boolean[N][M];
			DevRow = new ArrayList<>();
			DevCol = new ArrayList<>();
			int row = 0;
			int col = 0;
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				map[i] = str.toCharArray();
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 'S') {
						row = i;
						col = j;
					} else if(map[i][j] == '*') {
						DevRow.add(i);
						DevCol.add(j);
						visited[i][j] = true;
					} else if(map[i][j] == 'X') {
						visited[i][j] = true;
					}
				}
			}
			int result = bfs(row, col);
			if(result == -1) {
				System.out.println("#" + tc + " " + "GAME OVER");
			}else {
				System.out.println("#" + tc + " " + result);
			}
		}
	}
	
	private static int bfs(int row, int col) {
		visited[row][col] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i = 0; i < DevRow.size(); i++) {
			queue.add(new int[]{DevRow.get(i), DevCol.get(i), '*', 0});
		}
		queue.add(new int[] {row, col, 'S', 0});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int depth = cur[3];
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dx[i];
				int nc = cur[1] + dy[i];
				if(cur[2] == '*') {
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 'D') continue;
					visited[nr][nc] = true;
					queue.add(new int[] {nr, nc, '*', depth+1});
				} else if(cur[2] == 'S') {
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
					else if(map[nr][nc] == 'D') return depth+1;
					queue.add(new int[] {nr, nc, 'S', depth+1});
					visited[nr][nc] = true;
				}
			}
		}
		return -1;
	}

}

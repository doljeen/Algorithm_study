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
	public static char[][] arr;
	public static boolean[][] visited;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static List<Integer> fRow, fCol;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		visited = new boolean[N][M];
		fRow = new ArrayList<>();
		fCol = new ArrayList<>();
		int Jrow = 0;
		int Jcol = 0;
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			arr[i] = str.toCharArray();
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == '#') visited[i][j] = true;
				else if(arr[i][j] == 'J') {
					Jrow = i;
					Jcol = j;
				}else if(arr[i][j] == 'F') {
					fRow.add(i);
					fCol.add(j);
					visited[i][j] = true;
				}
			}
		}
		int result = Jbfs(Jrow, Jcol);
		if(result == -1) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(result);
		}
	}
	
	public static int Jbfs(int jRow, int jCol) {
		visited[jRow][jCol] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i = 0; i < fCol.size(); i++) {
			queue.add(new int[] {fRow.get(i), fCol.get(i), 'f', 0});
		}
		queue.add(new int[] {jRow, jCol, 'j', 0});
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int curR = current[0];
			int curC = current[1];
			int state = current[2];
			int depth = current[3];
			for(int i = 0; i < 4; i++) {
				int nr = curR + dx[i];
				int nc = curC + dy[i];
				if(state == 'f') {
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
					queue.add(new int[] {nr, nc, 'f', depth+1});
					arr[nr][nc] = 'f';
					visited[nr][nc] = true;
				} else if(state == 'j') {
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) return depth+1;
					if(visited[nr][nc]) continue;
					queue.add(new int[] {nr, nc, 'j', depth+1});
					visited[nr][nc] = true;
				}
			}
		}
		return -1;
	}
}
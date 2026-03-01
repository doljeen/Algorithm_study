import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static char[][] arr;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new char[5][5];
		boolean[][] visited = new boolean[5][5];
		for(int i = 0; i < 5; i++) {
			String str = br.readLine();
			arr[i] = str.toCharArray();
		}
		combi(0, 0, 0, visited);
		System.out.println(result);
	}
	public static void combi(int start, int cnt, int Scnt, boolean[][] visited) {
		
		if(cnt == 7) {
			if(Scnt >= 4) {
				boolean[][] selected = new boolean[5][5];
				int s = 0;
				int e = 0;
				for(int i = 0; i < 5; i++) {
					for(int j = 0; j < 5; j++) {
						selected[i][j] = visited[i][j];
						if(selected[i][j]) {
							s = i;
							e = j;
						}
					}
				}
				if(bfs(s, e, selected)) {
					result++;
				}
			}
			return;
		}
		if(start >= 25) return;

		int nr = start / 5; 
		int nc = start % 5;
		visited[nr][nc] = true;
		combi(start+1, cnt+1, arr[nr][nc]== 'S' ? Scnt+1: Scnt, visited);
		visited[nr][nc] = false;
		combi(start+1, cnt, Scnt, visited);
	}
	
	public static boolean bfs(int s, int e, boolean[][] visited) {
		int cnt = 0;
		visited[s][e] = false;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {s, e});
		
		while(!queue.isEmpty()) {
			cnt++;
			int[] cur = queue.poll();
			for(int i = 0; i < 4; i++) {
				int nr = cur[0] + dx[i];
				int nc = cur[1] + dy[i];
				if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || !visited[nr][nc]) continue;
				visited[nr][nc] = false;
				queue.add(new int[] {nr, nc});
			}
		}
		return cnt == 7;
	}

}

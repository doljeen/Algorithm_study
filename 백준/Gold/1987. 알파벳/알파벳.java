import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int r, c, max;
	public static char[][] arr;
	public static boolean[] ans;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		ans = new boolean[26];
		arr = new char[r][c];
		max = 0;
		for(int i = 0; i < r; i++) {
			String str = br.readLine();
			arr[i] = str.toCharArray();
		}
		dfs(0, 0, 1);
		System.out.println(max);
	}
	private static void dfs(int start, int end, int count) {
		if(max < count) max = count;
		ans[arr[start][end]-'A'] = true;
		for(int i = 0; i < 4; i++) {
			int nr = start + dx[i];
			int nc = end + dy[i];
			if(nr < 0 || nr >= r || nc < 0 || nc >= c || ans[arr[nr][nc]-'A']) continue;
			dfs(nr, nc, count+1);
		}
		ans[arr[start][end]-'A'] = false;
			
		
	}
}

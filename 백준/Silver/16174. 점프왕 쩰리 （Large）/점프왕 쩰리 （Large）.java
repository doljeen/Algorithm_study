import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static String result;
	static int N;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		result = "Hing";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		System.out.println(result);
	}
	
	public static void dfs(int start, int end) {
		if(start >= N || end >= N || arr[start][end] == 0) return;
		if(start == N-1 && end == N-1) {
			result = "HaruHaru";
			return;
		}
		if(visited[start][end]) return;
		visited[start][end] = true;
		int curValue = arr[start][end];
		int row = start + curValue;
		int col = end + curValue;
		dfs(row, end);
		dfs(start, col);
	}

}

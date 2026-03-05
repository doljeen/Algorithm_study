import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[][] small, big;
	public static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		small = new int[N][N];
		big = new int[N][N];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			small[a][b] = 1;
			big[b][a] = 1;
		}
		int result = 0;
		for(int i = 0; i < N; i++) {
			int smallCnt = bfs(i, true);
			int bigCnt = bfs(i, false);
			if(smallCnt + bigCnt == N-1) {
				result++;
			}
		}
		
		
		System.out.println(result);
		
	}
	public static int bfs(int start, boolean state) {
		int cnt = 0;
		Queue<Integer> queue = new ArrayDeque();
		boolean[] visited = new boolean[N];
		visited[start] = true;
		queue.add(start);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int current = queue.poll();
				for(int j = 0; j < N; j++) {
					if(state) {
						if(big[current][j] != 0 && !visited[j]) {
							cnt++;
							visited[j] = true;
							queue.add(j);
						}						
					} else {
						if(small[current][j] != 0 && !visited[j]) {
							cnt++;
							visited[j] = true;
							queue.add(j);
						}		
					}
				}
			}
		}
		return cnt;
	}
	

}

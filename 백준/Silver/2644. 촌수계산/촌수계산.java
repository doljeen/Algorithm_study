
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int M;
	public static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int target = Integer.parseInt(st.nextToken())-1;
		M = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			arr[u][v] = 1;
			arr[v][u] = 1;
		}
		
		int depth = bfs(start, target);
		System.out.println(depth);
		
	}
	
	private static int bfs(int start, int target) {
		int count = 0;
		// 큐생성
		Queue<Integer> queue = new ArrayDeque<>();
		// 방문관리 배열 생성
		boolean[] visited = new boolean[N];
		// 시작정점 방문처리 후 큐에 넣기
		visited[start] = true;
		queue.offer(start);
		// 큐에 탐색 정점이 있을 때 까지 반복
		while(!queue.isEmpty()) {
			count++;
			// 탐색 대상 큐에서 꺼내기
			int size = queue.size();
			for (int i=0;i<size;i++) {
				int current = queue.poll();		
				// 탐색 대상의 인접정점 처리
				for(int j = 0; j < N; j++) {
					// 미방문 인접정점(current 너비 +1)이면 방문 처리 후 큐에 넣기
					if(arr[current][j] != 0 && !visited[j]) {
						visited[j] = true;
						queue.offer(j);
						if(j == target) {
							return count;
						}
					}
				}
			}
		}
		return -1;
	}
}
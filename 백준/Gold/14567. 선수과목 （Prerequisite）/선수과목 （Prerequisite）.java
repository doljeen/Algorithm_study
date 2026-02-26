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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] result = new int[N];
		List<Integer>[] list = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			list[A].add(B);
			arr[B]++;
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			if(arr[i] == 0) {
				queue.add(new int[]{i, 1});
				result[i] = 1;
			}
		}
		
		boolean[] visited = new boolean[N];
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int num = current[0];
			int depth = current[1];
			visited[num] = true;
			for(int next : list[num]) {
				arr[next]--;
				if(arr[next] == 0) {
					queue.add(new int[]{next, depth+1});
					result[next] = depth+1;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(result[i]);
		}
	}
}
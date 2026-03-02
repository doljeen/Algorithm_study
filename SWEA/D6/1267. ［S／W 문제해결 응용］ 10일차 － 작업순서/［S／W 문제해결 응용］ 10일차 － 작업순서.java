import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			boolean[] visited = new boolean[N];
			List<Integer>[] list = new ArrayList[N];
			for(int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				int A = Integer.parseInt(st.nextToken())-1;
				int B = Integer.parseInt(st.nextToken())-1;
				list[A].add(B);
				arr[B]++;
			}
			Queue<Integer> queue = new ArrayDeque<>();
			for(int i= 0; i < N; i++) {
				if(arr[i] == 0) {
					queue.add(i);
				}
			}
			System.out.print("#" + tc + " ");
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				System.out.print(cur+1 + " ");
				visited[cur] = true;
				for(int next : list[cur]) {
					arr[next]--;
					if(arr[next] == 0) {
						queue.add(next);
					}
				}
			}
			System.out.println();
		}
	}

}

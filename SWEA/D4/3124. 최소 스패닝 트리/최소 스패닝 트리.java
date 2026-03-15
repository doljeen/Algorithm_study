import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){
			int v = sc.nextInt();
			int e = sc.nextInt();
			List<int[]>[] list = new ArrayList[v];
			for(int i = 0; i < v; i++) {
				list[i] = new ArrayList<>();
			}
			for(int i = 0; i < e; i++) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				int c = sc.nextInt();
				list[a].add(new int[] {b, c});
				list[b].add(new int[] {a, c});
			}
			PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
			pq.add(new int[] {0, 0});
			boolean[] visited = new boolean[v];
			long result = 0;
			while(!pq.isEmpty()) {
				
				int[] cur = pq.poll();
				if(visited[cur[0]]) continue;
				visited[cur[0]] = true;
				result += cur[1];
				
				for(int[] next: list[cur[0]]) {
					if(visited[next[0]]) continue;
					pq.add(next);
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}
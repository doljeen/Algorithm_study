import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			int priority = 0;
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Queue<int[]> q = new ArrayDeque<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
			for(int i = 0; i < N; i++) {
				if(i == target) {
					priority = arr[i];
				}
				q.add(new int[] {i, arr[i]});
				pq.add(arr[i]);
			}
			int cnt = 0;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				if(cur[1] == pq.peek()) {
					pq.poll();
					cnt++;
					if(cur[0] == target) {
						System.out.println(cnt);
						break;
					}
				}else {
					q.add(cur);
				}
			}
		}
	}

}

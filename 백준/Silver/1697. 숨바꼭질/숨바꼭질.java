
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int state = 0;
		int result = 0;
		visited = new boolean[100001];
		result = bfs(N, K, state);
		
		System.out.println(result);
	}
	
	public static int bfs(int start, int target, int state) {
		visited[start] = true;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {start, state});
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			if(current[0] == target) return current[1];
			int minus = current[0]-1;
			int plus = current[0]+1;
			int multi = current[0]*2;
			if(minus >= 0 && !visited[minus]) {
				queue.offer(new int[] {minus, current[1]+1});
				visited[minus] = true;
			}
			if(plus <= 100000 && !visited[plus]) {
				queue.offer(new int[] {plus, current[1]+1});
				visited[plus] = true;
			}
			if(multi > 0 && multi <= 100000 && !visited[multi]) {
				queue.offer(new int[] {multi, current[1]+1});
				visited[multi] = true;
			}
		}
		return 0;
	}
}
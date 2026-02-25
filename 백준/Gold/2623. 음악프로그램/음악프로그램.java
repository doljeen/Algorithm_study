
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] list = new ArrayList[N];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		Queue<Integer> queue = new ArrayDeque<>();
		int[] arr = new int[N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			
			int prev = -1;
			for(int j = 0; j < K; j++) {
				int tmp = Integer.parseInt(st.nextToken())-1;
				if (j != 0) {
					arr[tmp]++;
					list[prev].add(tmp);
				}
				prev = tmp;
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(arr[i] == 0) {
				queue.add(i);
			}
		}
		boolean[] visited = new boolean[N];
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current+1).append("\n");
			visited[current] = true;
			for(int next : list[current]) {
				arr[next]--;
				if(arr[next] == 0) {
					queue.add(next);
				}
			}
		}
		int isok = 0;
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				isok++;
			}
		}
		if(isok > 0) {
			System.out.println(0);
		}
		else {
			System.out.println(sb);
		}
	}

}

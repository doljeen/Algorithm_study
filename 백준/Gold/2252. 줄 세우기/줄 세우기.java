
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
		
		
		// 순서 1 화살표 개수 세기
		int[] arr = new int[N];
		// 순서 2 화살표 개수 0개인거 큐에 추가하기 싫으면 하지않기
		List<Integer>[] list = new ArrayList[N];
		for (int i=0;i<N;i++) list[i] = new ArrayList<Integer>();
		
		// 순서 3 0개인거 뺘면서 출력하면서 0개 도달하면 큐에 넣기싫으면 안넣기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
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
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + 1 + " ");
			for (int next : list[current]) {
				arr[next]--;
				if (arr[next] == 0)
					queue.add(next);
			}
		}
	}
}
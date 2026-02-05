import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int M, arr[];
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new boolean[M+1];
		Permu(0, 0);
	}
	
	public static void Permu(int start, int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start+1; i <= N; i++) {
			arr[cnt] = i;
			Permu(i, cnt+1);
			
		}
	}

}

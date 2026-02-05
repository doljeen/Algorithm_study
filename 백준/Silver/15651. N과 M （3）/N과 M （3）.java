import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int arr[], result[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		StringBuilder sb = new StringBuilder();
		Permu(0, sb);
		System.out.println(sb);
	}
	public static void Permu(int cnt, StringBuilder sb) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i <= N; i++) {
			arr[cnt] = i;
			Permu(cnt+1, sb);
		}
	}
}
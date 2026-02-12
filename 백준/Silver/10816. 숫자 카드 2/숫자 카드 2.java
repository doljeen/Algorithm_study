import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ans = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			ans[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		Arrays.sort(ans);
		for(int i = 0; i < M; i++) {
			int upper = 0;
			int lower = 0;
			upper = getUpper(ans, arr[i]);
			lower = getLower(ans, arr[i]);
			sb.append((upper - lower) + " ");
		}
		System.out.println(sb);
		
	}
	
	public static int getUpper(int[] ans, int target) {
		int s = 0;
		int e = ans.length;
		while(s < e) {
			int m = (s+e)/2;
			if(ans[m] <= target) {
				s = m+1;
			}else e = m;
		}
		return e;
	}
	
	public static int getLower(int[] ans, int target) {
		int s = 0;
		int e = ans.length;
		while(s < e) {
			int m = (s+e)/2;
			if(ans[m] < target) {
				s = m+1;
			}else e = m;
		}
		return e;
	}
}

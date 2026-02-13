import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static int N, M, bestValue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		int max = 0;
		bestValue = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i]) max = arr[i];
		}
		Arrays.sort(arr);
		slice(1, max);
		System.out.println(bestValue);
	}
	public static void slice(int start, int end) {
		if(start > end) return;
		int mid = (start + end + 1) /2;
		int s = UpperBound(mid);
		long result = 0;
		for(int i = s; i < N; i++) {
			result += (arr[i] - mid);
		}
		if(result >= M) {
			bestValue = mid;
			slice(mid+1, end);
		}
		else if(result < M){
			slice(start, mid-1);
		}
		
	}
	public static int UpperBound(int target) {
		int s = 0, e = arr.length, m;
		while(s < e) {
			m = (s+e) /2;
			if(arr[m] <= target) s = m+1;
			else e = m;
		}
		return e;
	}

}

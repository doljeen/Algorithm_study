
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, result;
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		int max = 0;
		int sum = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max < arr[i]) max = arr[i];
			sum += arr[i];
		}
		binarySearch(max, sum);
		System.out.println(result);
		
	}
	public static void binarySearch(int s, int e) {
		if(s > e) return;
		int mid = (s + e + 1) / 2;
		int cnt = 1;
		int tmp = mid;
		for(int i = 0; i < N; i++) {
			if(tmp - arr[i] < 0) {
				tmp = mid;
				cnt++;
			}
			tmp -= arr[i];
		}
		if(cnt > M) {
			binarySearch(mid+1, e);
		} else if(cnt <= M) {
			result = mid;
			binarySearch(s, mid-1);
		}
	}
}

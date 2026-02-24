
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, output;
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		int M = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int max = arr[N-1];
		
		if(sum <= M) {
			System.out.println(max);
		} else {
			binarySearch(0, max, M);
			System.out.println(output);
		}
	}
	
	public static void binarySearch(int left, int right, int target) {
		if(left > right) return;
		int result = 0;
		int mid = (left + right + 1) / 2;
		for(int i = 0; i < N; i++) {
			if(arr[i] > mid) {
				result += mid;
			}else {
				result += arr[i];					
			}
		}
		if(result <= target) {
			output = mid;
			binarySearch(mid+1, right, target);
		}else {
			binarySearch(left, mid-1, target);
		}
	}

}

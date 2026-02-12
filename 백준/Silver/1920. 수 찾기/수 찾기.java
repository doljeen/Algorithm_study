import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] A, arr;
	static int M;
	static List<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		int result = 0;
		for(int i = 0; i < M; i++) {
			result = divi(i, 0, N-1);
			list.add(result);
		}
		for(int i = 0; i < M; i++) {
			System.out.println(list.get(i));			
		}
	}
	
	public static int divi(int pick, int start, int end) {
		while(start <= end) {
			int mid = (start + end) / 2;
			if (arr[pick] == A[mid]) {
				return 1;
			} else if(arr[pick] > A[mid]) {
				start = mid + 1;
			} else if(arr[pick] < A[mid]) {
				end = mid - 1;
			}
		}
		return 0;
	}

}

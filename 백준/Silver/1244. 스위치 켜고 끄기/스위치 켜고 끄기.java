
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp == 1) {
				int value = Integer.parseInt(st.nextToken());
				for (int j=value-1;j<N;j+=value) {
					if(arr[j] == 1) {
						arr[j] = 0;
					}else {
						arr[j] = 1;
					}
				}
			}else {
				// 0 0 0 1 0
				int value = Integer.parseInt(st.nextToken())-1;
				for (int len = 0;len<N;len++) {
					int left = value - len;
					int right = value + len;
					if(left < 0 || right >= N) {
						break;
					}
					if (arr[left] == arr[right]) {
						if(left == right) {
							if(arr[left] == 1) {
								arr[left] = 0;
							}else {
								arr[left] = 1;
							}
						}else {							
							if(arr[left] == 1) {
								arr[left] = 0;
							}else {
								arr[left] = 1;
							}
							
							if(arr[right] == 1) {
								arr[right] = 0;
							}else {
								arr[right] = 1;
							}
						}
					}else {
						break;
					}
				}
			}
		}
		
		int out = 0;
		for(int i = 0; i < N; i++) {
			out++;
			System.out.print(arr[i] + " ");
			if(out >= 20) {
				out = 0;
				System.out.println();
			}
		}
	}
}

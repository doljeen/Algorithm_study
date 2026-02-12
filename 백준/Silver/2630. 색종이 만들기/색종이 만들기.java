import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int W, G;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		div(0, 0, N);
		System.out.println(W + "\n" + G);

	}
	
	public static void div(int r, int c, int size) {
		int sum = 0;
		
		for(int i = r; i < r+size; i++) {
			for(int j = c; j < c+size; j++) {
				sum += arr[i][j];
			}
		}
		
		if(sum == size*size) {
			G++;
		}else if(sum == 0) {
			W++;
		}else {
			int half = size / 2;
			div(r, c, half);
			div(r, c+half, half);
			div(r+half, c, half);
			div(r+half, c+half, half);
		}
		
	}

}

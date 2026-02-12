import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			char[] carr = str.toCharArray();
			for(int j = 0; j < N; j++) {
				arr[i][j] = carr[j] - '0';
			}
		}
		div(0, 0, N);
		System.out.println(sb);
	}
	
	public static void div(int r, int c, int size) {
		int sum = 0;
		for(int i = r; i < r+size; i++) {
			for(int j = c; j < c+size; j++) {
				sum += arr[i][j];
			}
		}
		
		if(sum == size*size) {
			sb.append(1);
		} else if(sum == 0) {
			sb.append(0);
		} else {
			int half = size /2;
			sb.append("(");
			div(r, c, half);
			div(r, c+half, half);
			div(r+half, c, half);
			div(r+half, c+half, half);
			sb.append(")");
		}
		
	}

}

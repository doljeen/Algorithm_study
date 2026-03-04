import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, max, fixed = 3;
	public static int[][] arr;
	public static int[] advance;
	public static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		visited = new boolean[9];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] order = new int[9];
		order[3] = 0;
		visited[0] = true;
		permu(0, order);
		System.out.println(max);
	}
	public static int inning(int[] order) {
		int result = 0;
		int idx = 0;
		for(int i = 0; i < N; i++) {
			advance = new int[3];
			int score = 0;
			int outcount = 0;
			while(outcount < 3) {
				int num = arr[i][order[idx]];
				if(num == 0) {
					outcount++;
				}else if(num >= 1 && num <= 3) {
					for(int j = 2; j >= 0; j--) {
						if(advance[j] == 1) {
							if(j + num >= 3) {
								score++;
							} else {
								advance[j+num] = 1;
							}
							advance[j] = 0;
						}
					}
					advance[num-1] = 1;
				}
				else if(num == 4) {
					for(int j = 2; j >= 0; j--) {
						if(advance[j] == 1) {
							advance[j] = 0;
							score++;
						}
					}
					score++;
				}
				idx++;
				if(idx >= 9) idx = 0;
			}
			result += score;
			
		}
		return result;
	}
	private static void permu(int start, int[] order) {
		if(start == 3) {
			permu(start+1, order);
			return;
		}
		if(start == 9) {
			max = Math.max(max, inning(order));
			return;
		}
		for(int i = 0; i < 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				order[start] = i;
				permu(start+1, order);
				visited[i] = false;
			}
			
		}
	}
}

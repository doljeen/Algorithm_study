import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int M;
	private static boolean[] isSelected;
	private static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		isSelected = new boolean[N+1];
		Permu(0);
		
		
	}
	
	public static void Permu(int cnt) {
		if(cnt == M) {
			for(int i =0; i < M; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			numbers[cnt] = i;
			Permu(cnt+1);
			isSelected[i] = false;
		}
	}

}

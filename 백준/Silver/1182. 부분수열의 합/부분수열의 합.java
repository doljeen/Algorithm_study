import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, S, totalcnt;
	public static int[] arr;
	public static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		totalcnt = 0;
		arr = new int[N];
		isSelected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Per(0, 0);
		System.out.println(totalcnt);
	}
	public static void Per(int cnt, int pick) {
		if(cnt == N) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) sum+=arr[i]; 
			}
			if(pick > 0 && sum == S) totalcnt++;
			return;
		}
		isSelected[cnt] = true;
		Per(cnt+1, pick+1);
		isSelected[cnt] = false;
		Per(cnt+1, pick);
		
	}

}

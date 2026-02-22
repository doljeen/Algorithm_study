import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int L, C;
	public static char[] arr, combi;
	public static char[] mo = {'a', 'e', 'i', 'o', 'u'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		combi = new char[L];
		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		dfs(0, 0);
	}
	public static void dfs(int cnt, int pick) {
		if(cnt == L) {
			int isOk = 0;
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < L; j++) {
					if(mo[i] == combi[j])
						isOk++;
				}
			}
			if(isOk < 1) {
				return;
			}else if(L - isOk < 2) {
				return;
			}
			for(int i = 0; i < L; i++) {
				System.out.print(combi[i]);
			}
			System.out.println();
			return;
		}
		if(pick == C) return;
		combi[cnt] = arr[pick];
		dfs(cnt+1, pick+1);
		dfs(cnt, pick+1);

	}
}

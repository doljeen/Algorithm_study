import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void dfs(int lastIndex, char[] arr, int current) {
		if(current*2+1 <= lastIndex) {
			dfs(lastIndex, arr, current*2+1);
		}
		System.out.print(arr[current]);
		if(current*2+2 <= lastIndex) {
			dfs(lastIndex, arr, current*2+2);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 1; i <= 10; i++) {
			int n = Integer.parseInt(br.readLine());
			char [] arr = new char [n];
			for (int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				char c = st.nextToken().charAt(0);
				arr[j] = c;
				while (st.hasMoreTokens()) {
					st.nextToken();
				}
			}
			System.out.print("#" + i + " ");
			dfs(n-1, arr, 0);
			System.out.println();
		}
	}

}
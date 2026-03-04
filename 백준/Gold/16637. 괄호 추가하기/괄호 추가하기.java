import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N, max;
	public static char[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		arr = str.toCharArray();
		max = Integer.MIN_VALUE;
		dfs(1, arr[0]-'0');
		
		System.out.println(max);
	}
	private static int calc(int curCalc, char op, int nextNum) {
		switch(op){
		case '+':
			curCalc += nextNum;
			break;
		case '-':
			curCalc -= nextNum;
			break;
		case '*':
			curCalc *= nextNum;
			break;
	}
		return curCalc;
	}
	
	public static void dfs(int idx, int curCalc) {
		if(idx >= N) {
			max = Math.max(max, curCalc);
			return;
		}
		int next = calc(curCalc, arr[idx], arr[idx+1]-'0');
		dfs(idx+2, next);
		if(idx+2 < N) {
			int add = calc(arr[idx+1]-'0', arr[idx+2], arr[idx+3]-'0');
			int plus = calc(curCalc, arr[idx], add);
			dfs(idx+4, plus);			
		}
	}

}

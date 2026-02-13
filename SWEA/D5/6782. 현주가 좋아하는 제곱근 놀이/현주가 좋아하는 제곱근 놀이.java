import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int totalCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int TC = 1; TC <=T; TC++) {
			totalCnt = 0;
			long N = Long.parseLong(br.readLine());
			while(true) {
				if(N == 2) break;
				if(Math.sqrt(N) == (long)(Math.sqrt(N))) {
					totalCnt++;
					N = (long) Math.sqrt(N);
				}else {
					long tmp = (long) ((long)(Math.sqrt(N) + 1) * (long)(Math.sqrt(N) + 1));  
					totalCnt += (tmp - N);
					N = tmp;
				}
			}
			System.out.println("#" + TC + " " + totalCnt);
		}
	}
}
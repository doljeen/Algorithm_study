import java.util.Scanner;

public class Solution {
	static int N, totalCnt;
	static boolean[] col, slash, bSlash;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			totalCnt = 0;
			col = new boolean[N+1];
			slash = new boolean[2*N+1];
			bSlash = new boolean[2*N+1];
			setQueen(1);
			System.out.println("#" + test_case + " " + totalCnt);			
		}
		
	}
	static void setQueen(int row) {
		if(row > N) {
			totalCnt++;
			return;
		}
		for(int c = 1; c <= N; c++) {
			if(col[c] || slash[row+c] || bSlash[(row-c)+N]) continue;
			col[c] = slash[row+c] = bSlash[(row-c)+N] = true;
			setQueen(row+1);
			col[c] = slash[row+c] = bSlash[(row-c)+N] = false;
		}
	}
}

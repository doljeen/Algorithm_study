import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map, maxMap;
	static int N, M, C;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			maxMap = new int[N][N-M+1];
			for(int i = 0; i< N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + test_case + " " + maxHoney());
			
		}
			
	}
	public static int maxHoney(){
		// 연속된 M개를 선택할 수 있는 모든 행의 열의 위치마다 최대 이익 계산
		makeMaxMap();
		// 두 일꾼 선택 조합
		return processCombination();
		
	}
	private static void makeMaxMap() {
		for(int i = 0; i < N; i++) { // 각 행마다 반복
			for(int j = 0; j <= N-M; j++) {
				// i, j 위치에서 부분집합을 따져보고 최대이익 계산
				subset(i, j, 0, 0, 0);
			}
		}
	}
	private static void subset(int i, int j, int cnt, int sum, int powSum) {
		if(sum > C) return;
		if(cnt==M) { // 가지치기
			if(maxMap[i][j-M]<powSum) maxMap[i][j-M] = powSum; 
			return;
		}
		// i, j 벌통을 포함
		subset(i, j+1, cnt+1, sum+map[i][j], powSum+map[i][j]*map[i][j]);
		// i, j 벌통을 미포함
		subset(i, j+1, cnt+1, sum, powSum);
	}
	
	
	private static int processCombination() {
		int aBenefit, bBenefit, max = 0;
		// 일꾼 A 선택
		for(int i =0; i < N; i++) {
			for(int j = 0; j <= N-M; j++) {
				aBenefit = maxMap[i][j];
				// 일꾼 B 선택
				bBenefit = 0;
				for(int p = i; p < N; p++) {
					int start = (i==p)?j+M: 0;
					for(int q = start; q <= N-M; q++) {
						if(bBenefit < maxMap[p][q]) {
							bBenefit = maxMap[p][q];
						}
					}
				}
				if(max < aBenefit+bBenefit) {
					max = aBenefit+bBenefit;
				}
				
			}
		}
		return max;
	}
}
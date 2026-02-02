
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String str = sc.next();
		// 알파벳 최소 개수
		int[] minCnt = new int[4];
		for(int i =0; i < 4; i++) {
			minCnt[i] = sc.nextInt();
		}
		// 현재 카운트한 최소 개수
		int[] curCnt = new int[4];
		int result = 0;
		for(int i = 0; i < M; i++) {
			if(str.charAt(i) == 'A')
				curCnt[0]++;
			else if(str.charAt(i) == 'C')
				curCnt[1]++;
			else if(str.charAt(i) == 'G')
				curCnt[2]++;
			else if(str.charAt(i) == 'T')
				curCnt[3]++;
		}
		boolean flag = true;
		for(int i = 0; i < 4; i++) {
			if(minCnt[i] > curCnt[i]) {
				flag = false;
				break;
			}
		}
		if (flag) result++;
		for(int i = 1; i <= N-M; i++) {
			if(str.charAt(i-1) == 'A')
				curCnt[0]--;
			else if(str.charAt(i-1) == 'C')
				curCnt[1]--;
			else if(str.charAt(i-1) == 'G')
				curCnt[2]--;
			else if(str.charAt(i-1) == 'T')
				curCnt[3]--;
			
			if(str.charAt(i+M-1) == 'A')
				curCnt[0]++;
			else if(str.charAt(i+M-1) == 'C')
				curCnt[1]++;
			else if(str.charAt(i+M-1) == 'G')
				curCnt[2]++;
			else if(str.charAt(i+M-1) == 'T')
				curCnt[3]++;
			flag = true;
			for(int k = 0; k < 4; k++) {
				if(minCnt[k] > curCnt[k]) {
					flag = false;
					break;
				}
			}
			if (flag) result++;
		}
		
		
		System.out.println(result);
		
	}
}
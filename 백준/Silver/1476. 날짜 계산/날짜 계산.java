import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		//년도 증가하는 변수
		int Ecnt = 0;
		int Scnt = 0;
		int Mcnt = 0;
		
		// 결과 저장하는 변수
		int result = 0;
		
		// 년도 계산
		while(true) {
			Ecnt++; Scnt++; Mcnt++;
			
			// E, S, M 조건 별로 변수 초기화
			if(Ecnt > 15) Ecnt = 1;
			if(Scnt > 28) Scnt = 1;
			if(Mcnt > 19) Mcnt = 1;
			result++;
			
			// 년도 증가 변수가 입력 받은 변수와 같으면 반복문 빠져나옴
			if(E == Ecnt && S == Scnt && M == Mcnt) break;
		}
		
		System.out.println(result);
		
	}
}

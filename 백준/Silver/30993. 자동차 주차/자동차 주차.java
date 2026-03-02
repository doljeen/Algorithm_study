import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int Aresult = 1;
		int Bresult = 1;
		int Cresult = 1;
		for(int i = 1; i <= N; i++) {
			if(i > A) break;
			Aresult = Aresult * (N - i + 1) / i;
		}
		for(int i = 1; i <= N-A; i++) {
			if(i > B) break;
			Bresult = Bresult * ((N-A) - i + 1) / i;
		}
		
		for(int i = 1; i <= N-A-B; i++) {
			if(i > C) break;
			Cresult = Cresult * ((N-A-B) - i + 1) / i;
		}
		int result = Aresult*Bresult*Cresult;
		System.out.println(result);
	}

}

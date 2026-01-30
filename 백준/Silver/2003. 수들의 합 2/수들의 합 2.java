import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		// 크기 N인 배열
		int[] arr = new int[N];
		
		// 결과 저장 변수
		int result = 0;
		
		// 입력 받은 수로 배열 초기화
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 수열 갯수 세는 코드
		for(int i = 0; i < N; i++) {
			// 첫번째 for문에서 첫 위치index 설정
			int sum = arr[i];
			// 그 값이 M일 때 count + 1
			if(sum == M) result++;
			for(int j = i+1; j < N; j++) {
				// i+1번째 배열에서 부터 순회하고 더해서 M과 같은지 확인
				sum += arr[j];
				if(sum == M) {
					result++;
					break;
				// sum이 M과 같으면 count + 1, M보다 크면 for문 탈출
				} else if(sum > M) {
					break;
				}
			}
		}
		System.out.println(result);
		
		
	}
}

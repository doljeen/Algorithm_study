
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		List<Integer> sum = new ArrayList<>();
		int temp = 0;
		sum.add(temp);
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			temp += arr[i];
			sum.add(temp);
		}
		
		for(int p = 0; p < M; p++) {
			int result = 0;
			int i = sc.nextInt();
			int j = sc.nextInt();
			result = sum.get(j) - sum.get(i-1);
			
			System.out.println(result);
		}
	}

}
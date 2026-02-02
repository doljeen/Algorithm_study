
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			arr.add(sc.nextInt());
		}
		long max = 0;
		long result = 0;
		for(int i = 0; i < N; i++) {
			if(i < M) {
				result += arr.get(i);
				max = Math.max(max, result);
			}else {
				result += arr.get(i);
				result -= arr.get(i - M);
				max = Math.max(max, result);
			}
			
		}
		System.out.println(max);
	}

}
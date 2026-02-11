import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int N;
	static String[] str;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		str = new String[N];
		for(int i = 0; i < N; i++) {
			str[i] = sc.next();
		}
		
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				char[][] Carr = new char[2][];
				int result = o1.length() - o2.length();
				if(o1.length() == o2.length()) {
					Carr[0] = o1.toCharArray();
					Carr[1] = o2.toCharArray();
					int[] sum = new int[2];
					for(int i = 0; i < 2; i++) {
						for(int j = 0; j < Carr[i].length; j++) {
							if(Carr[i][j] - '0' < 10) {
								sum[i] += Character.getNumericValue(Carr[i][j]);
							}
						}
					}
					if (sum[0] != sum[1])
						return sum[0] - sum[1];
					return o1.compareTo(o2);
				}
				return result;
			}});
		for(int i =0; i < N; i++) {
			System.out.println(str[i]);
		}
	}
}

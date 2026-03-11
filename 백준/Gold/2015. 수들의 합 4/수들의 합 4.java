import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Map<Long, Long> prefix = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		long sum = 0;
		long cnt = 0;
		prefix.put(sum, 1L);
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			sum += tmp;
			if(prefix.containsKey(sum - K)) {
				cnt += prefix.get(sum-K);
			}
			prefix.put(sum, prefix.getOrDefault(sum, 0L)+1);
		}
		
		System.out.println(cnt);
	}

}

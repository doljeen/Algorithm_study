import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			List<Integer> list = new ArrayList<>();
			int max = 0;
			int Midx = 0;
			int day = 0;
			int cnt1 = 0;
			int cnt2 = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(max < arr[i]) { 
					max = arr[i];
					Midx = i;
				}
			}
			for(int i = 0; i < N; i++) {
				if(Midx == i) continue;
				if(max -arr[i] != 0) {
					list.add(max - arr[i]);
				}
			}
			Collections.sort(list);
			for(int i = 0; i < list.size(); i++) {
				cnt2 += list.get(i) / 2;
				cnt1 += list.get(i) % 2;
			}
			if(cnt1 != cnt2) {
				while(cnt1 < cnt2-1) {
					cnt1 += 2;
					cnt2--;
				}
			}
			while(true) {
				if(cnt1 == 0 && cnt2 == 0) break;
				if(cnt1>0) {
					cnt1--;
				}
				day++;
				
				if(cnt1 == 0 && cnt2 == 0) break;
				if(cnt2>0) {
					cnt2--;
				}
				day++;
			}
			System.out.println("#" + test_case + " " + day);
		}
	}

}

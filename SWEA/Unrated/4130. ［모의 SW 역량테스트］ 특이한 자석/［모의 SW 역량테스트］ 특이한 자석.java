import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static List<Integer>[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int K = Integer.parseInt(br.readLine());
			arr = new ArrayList[4];
			for (int i = 0; i < 4; i++)
				arr[i] = new ArrayList<>();

			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					arr[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			for (int i = 0; i < K; i++) {
				boolean[] visited = new boolean[4];
				StringTokenizer st = new StringTokenizer(br.readLine());
				int mag = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				Rotation(mag-1, dir, visited);
				
			}
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				if (arr[i].get(0) == 1)
					sum += (int) Math.pow(2, i);
			}
			System.out.println("#" + test_case + " " + sum);
			
		}
	}

	public static void Rotation(int mag, int dir, boolean[] visited) {
		if (visited[mag]) {
			return;
		}
		visited[mag] = true;
		// 본인 왼쪽 오른쪽 저장
		int left = arr[mag].get(6);
		int right = arr[mag].get(2);

		// 왼쪽에 톱니바퀴가 있을 경우
		if (mag-1 >= 0) {
			// 왼쪽 톱니바퀴의 오른쪽 != 본인 왼쪽
			if (arr[mag-1].get(2) != left) {
				// 왼쪽 돌려라
				Rotation(mag-1, -dir, visited);
			} 
		}

		// 오른쪽에 톱니바퀴가 있을 경우
		if (mag+1 < 4) {
			// 오른쪽 톱니바퀴의 왼쪽 != 본인 오른쪽
			if (arr[mag+1].get(6) != right) {
				// 오른쪽 돌려라
				Rotation(mag+1, -dir, visited);
			} 
		}
		
		// 내꺼 돌려야지
		if (dir == 1) {
			arr[mag].add(0, arr[mag].remove(7));
		} else {
			arr[mag].add(arr[mag].remove(0));
		}
		
	}
}
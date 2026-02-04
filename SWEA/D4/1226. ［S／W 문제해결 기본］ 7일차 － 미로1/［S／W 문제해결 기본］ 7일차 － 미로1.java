
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static class Pos{
		int row;
		int col;
		
		Pos(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	public static int bfs(int row, int col, char[][] arr, boolean[][] visited) {
		int result = 0;
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(row, col));
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		while(!(queue.isEmpty())){
			Pos p = queue.poll();
			visited[p.row][p.col] = true;
			for(int i = 0; i < 4; i++) {
				int curR = p.row + dr[i];
				int curC = p.col + dc[i];
				if(curR < 0 || curC < 0 || curR >= 16 || curC >= 16 || visited[curR][curC]) {
					continue;
				}
				if(arr[curR][curC] == '3') {
					return 1;
				}
				queue.add(new Pos(curR, curC));
			}
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			char[][] arr = new char[16][16];
			boolean[][] visited = new boolean[16][16];
			int result = 0;
			int start = 0;
			int end = 0;
			for(int i = 0; i < 16; i++) {
				String str = sc.next();
				arr[i] = str.toCharArray();
			}
			for(int i = 0; i < 16; i++) {
				for(int j = 0; j < 16; j++) {
					if(arr[i][j] == '1') {
						visited[i][j] = true;
					}
					if(arr[i][j] == '2') {
						start = i;
						end = j;
					}
				}
			}
			result = bfs(start, end, arr, visited);
			System.out.println("#" + test_case + " " + result);
			
		}

	}

}
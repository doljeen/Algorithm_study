import java.util.*;
import java.io.*;

public class Solution {
    
	static int[][] arr;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {-1, 0, 1, 0};
	static Set<Integer> numList;
	
	static void dfs(int y, int x, int depth, int curNum) {
		
		if (depth == 6) {
			numList.add(curNum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny >= 0 && nx >= 0 && ny < 4 && nx < 4) {
				dfs(ny, nx, depth + 1, curNum * 10 + arr[ny][nx]);
			}
		}
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++) {

            arr = new int[4][4];
            numList = new HashSet<>();
            
            for (int i = 0; i < 4; i++) {
            	st = new StringTokenizer(br.readLine());
            	for (int j = 0; j < 4; j++) {
            		arr[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            
            for (int i = 0; i < 4; i++) {
            	for (int j = 0; j < 4; j++) {
            		dfs(i, j, 0, arr[i][j]);
            	}
            }
            
            System.out.println("#" + tc + " " + numList.size());
        }
    }
}
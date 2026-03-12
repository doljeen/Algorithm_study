import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] map;
    static int[][][] dist;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    
    public static void bfs() {
    	Queue<int[]> q = new ArrayDeque<>();
    	
    	q.add(new int[] {0, 0, 0, 1});
    	dist[0][0][0] = 1;
    	
    	while(!q.isEmpty()) {
    		int cur[] = q.poll();
    		int y = cur[0];
    		int x = cur[1];
    		int crashed = cur[2];
    		int d = cur[3];
    		
    		if (y == n - 1 && x == m - 1) return;
    		
    		for (int i = 0; i < 4; i++) {
    			int ny = y + dy[i];
    			int nx = x + dx[i];
    			
    			if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
    			
    			if (map[ny][nx] == 1) {
                    // 아직 벽을 부순 적이 없고, 그 벽을 부수고 방문한 적이 없을 때
                    if (crashed == 0 && dist[ny][nx][1] > d + 1) {
                        dist[ny][nx][1] = d + 1;
                        q.add(new int[] {ny, nx, 1, d + 1});
                    }
                } 
                // 2. 빈 공간을 만났을 때
                else {
                    // 현재 상태(벽 부숨 여부) 그대로 다음 칸에 방문한 적이 없을 때
                    if (dist[ny][nx][crashed] > d + 1) {
                        dist[ny][nx][crashed] = d + 1;
                        q.add(new int[] {ny, nx, crashed, d + 1});
                    }
                }
    		}
    		
    	}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        dist = new int[n][m][2];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		Arrays.fill(dist[i][j], Integer.MAX_VALUE);
        	}
        }
        
        for (int i = 0; i < n; i++) {
        	String s = br.readLine();
        	for (int j = 0; j < m; j++) {
        		map[i][j] = s.charAt(j) - '0';
        	}
        }
        
        bfs();
        
        int ans = (Math.min(dist[n - 1][m - 1][0], dist[n - 1][m - 1][1]) == Integer.MAX_VALUE) 
        		? -1 : Math.min(dist[n - 1][m - 1][0], dist[n - 1][m - 1][1]);
        
        System.out.println(ans);
        
        
    }
    
}
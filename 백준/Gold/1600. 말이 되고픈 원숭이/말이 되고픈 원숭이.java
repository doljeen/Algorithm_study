import java.util.*;
import java.io.*;

public class Main {

    static int k, w, h;
    static int[][] arr;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int[] hdy = {-1, 1, 2, 2, 1, -1, -2, -2};
    static int[] hdx = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[][][] visited;
    static int ans;
    		
    static int bfs() {
    	Queue<int[]> q = new ArrayDeque<>();
    	q.add(new int[] {0, 0, 0, 0});
    	
    	while(!q.isEmpty()) {
    		int cur[] = q.poll();
    		int y = cur[0];
    		int x = cur[1];
    		int cnt = cur[2];
    		int dist = cur[3];
    		
    		if (y == h - 1 && x == w - 1) {
    			return dist;
    		}
    		//일반 이동
    		for (int i = 0; i < 4; i++) {
    			int ny = y + dy[i];
    			int nx = x + dx[i];
    			
    			if (ny < 0 || nx < 0 || ny >= h || nx >= w) continue;
    			
    			if (arr[ny][nx] == 1) continue;
    			
    			if (visited[ny][nx][cnt] > dist + 1) {
    				visited[ny][nx][cnt] = dist + 1;
    				q.add(new int[] {ny, nx, cnt, dist + 1});
    			}
    		}
    		
    		//말 이동
    		if (cnt < k) {
        		for (int i = 0; i < 8; i++) {
        			int ny = y + hdy[i];
        			int nx = x + hdx[i];
        			
        			if (ny < 0 || nx < 0 || ny >= h || nx >= w) continue;
        			
        			if (arr[ny][nx] == 1) continue;
        			
        			if (visited[ny][nx][cnt + 1] > dist + 1) {
        				visited[ny][nx][cnt + 1] = dist + 1;
        				q.add(new int[] {ny, nx, cnt + 1, dist + 1});
        			}
        		}
    		}
    	}
    	
    	return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        arr = new int[h][w];
        visited = new int[h][w][k + 1];
        
        for (int i = 0; i < h; i++) {
        	for (int j = 0; j < w; j++) {
        		Arrays.fill(visited[i][j], Integer.MAX_VALUE);
        	}
        }
        
        for (int i = 0; i < h; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < w; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        ans = bfs();
        
        System.out.println(ans);
        
    }
    
}
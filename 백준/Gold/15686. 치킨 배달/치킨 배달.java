
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, chickcnt, homecnt, min;
    public static int[][] map;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    static List<int[]>[] home;
    static List<int[]>[] chicken;
    static boolean[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        homecnt = 0;
        chickcnt = 0;
        min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 1) homecnt++;
        		else if(map[i][j] == 2) chickcnt++;
        	}
        }
        home = new ArrayList[homecnt];
        chicken = new ArrayList[chickcnt];
        selected = new boolean[chickcnt];
        for(int i = 0; i < homecnt; i++) {
        	home[i] = new ArrayList<>();
        }
        for(int j = 0; j < chickcnt; j++) {
        	chicken[j] = new ArrayList<>();
        }
        int hidx = 0;
        int cidx = 0;
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(map[i][j] == 1) home[hidx++].add(new int[] {i, j});
        		else if(map[i][j] == 2) chicken[cidx++].add(new int[] {i, j});
        	}
        }
        permu(0, 0);
        System.out.println(min);
       
    }
    public static void permu(int start, int depth) {
    	if(depth == M) {
    		min = Math.min(bfs(), min);
    		return;
    	}
    	
    	for(int i = start; i < chickcnt; i++) {
    		selected[i] = true;
    		permu(i+1, depth+1);
    		selected[i] = false;
    	}
    }
    
    public static int bfs() {
       boolean[][] visited = new boolean[N][N];
       Queue<int[]> queue = new ArrayDeque<>();
       for(int i = 0; i < chickcnt; i++) {
    	   if(selected[i]) {
    		   for(int[] dis : chicken[i]) {
    			   queue.add(new int[] {dis[0], dis[1], 0});  
    			   visited[dis[0]][dis[1]] = true;
    		   }
    	   }
       }
       
       int cnt = 0;
       int hcnt = 0;
       while(!queue.isEmpty()) {
    	   int[] cur = queue.poll();
    	   int curR = cur[0];
    	   int curC = cur[1];
    	   int depth = cur[2];
    	   for(int i = 0; i < 4; i++) {
    		   int nr = curR + dx[i];
    		   int nc = curC + dy[i];
    		   if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
    		   if(map[nr][nc] == 1) {
    			   cnt+= depth+1;
    			   hcnt++;
    		   }
    		   if(hcnt == homecnt) return cnt;
    		   visited[nr][nc] = true;
    		   queue.add(new int[] {nr, nc, depth+1});
    	   }
       }
       return Integer.MAX_VALUE;
    }
}

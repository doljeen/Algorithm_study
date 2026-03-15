
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[][] map;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            char[] arr = str.toCharArray();
            for(int j = 0; j < N; j++) {
                map[i][j] = arr[j] - '0';
            }
        }
        
       
        int result = bfs();
        System.out.println(result);
    }
    public static int bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[M][N];
        dq.addFirst(new int[] {0, 0, 0});
        while(!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            int curR = cur[0];
            int curC = cur[1];
            int weight = cur[2];
            if(curR == M-1 && curC == N-1) return weight;
            for(int i = 0; i < 4; i++) {
                int nr = curR + dx[i];
                int nc = curC + dy[i];
                if(nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc]) continue;
                if(map[nr][nc] == 0) {
                    dq.addFirst(new int[] {nr, nc, weight});
                    visited[nr][nc] = true;
                }else {
                    dq.addLast(new int[] {nr, nc, weight+1});
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }
}

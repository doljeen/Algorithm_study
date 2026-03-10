import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] arr;
    static int[][] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int ans;

    //섬들 간의 최소 거리 구하기
    static void getDist() {
        //y, x, value, dist
        Queue<int[]> dist_q = new ArrayDeque<>();

        int[][] dist_visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && canSearch(i, j)) {
                    dist_q.add(new int[] {i, j, visited[i][j], 0});
                    dist_visited[i][j] = visited[i][j];
                }
            }
        }

        while(!dist_q.isEmpty()) {
            int cur[] = dist_q.poll();
            int y = cur[0];
            int x = cur[1];
            int val = cur[2];
            int dist = cur[3];

            if (dist >= ans) continue;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                //바다 만남
                if (arr[ny][nx] == 0) {
                    //같은 섬에서 먼저 지나간 흔적이 존재
                    if (dist_visited[ny][nx] == val) continue;
                    //지나간 적이 없음
                    dist_visited[ny][nx] = val;
                    dist_q.add(new int[] {ny, nx, val, dist + 1});
                } else if (arr[ny][nx] == 1 && visited[ny][nx] != val) {
                    ans = Math.min(ans, dist);
                }
            }
        }

    }

    //섬의 갯수, 영역 구분하는 함수
    static void bfs(int i, int j, int val) {

        Queue<int[]> q = new ArrayDeque<>();
        visited[i][j] = val;
        q.add(new int[] {i, j});

        while(!q.isEmpty()) {
            int cur[] = q.poll();
            int y = cur[0];
            int x = cur[1];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (arr[ny][nx] == 1 && visited[ny][nx] == 0) {
                    visited[ny][nx] = val;
                    q.add(new int[] {ny, nx});
                }
            }
        }

    }

    static boolean canSearch(int i, int j) {
        for (int d = 0; d < 4; d++) {
            int ny = i + dy[d];
            int nx = j + dx[d];

            if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if (arr[ny][nx] == 0) return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        //섬의 구역, 갯수 세기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && visited[i][j] == 0) {
                    cnt++;
                    bfs(i, j, cnt);
                }
            }
        }
        
        ans = Integer.MAX_VALUE;

        getDist();

        System.out.println(ans);
    }

}
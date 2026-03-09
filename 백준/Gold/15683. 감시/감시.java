import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] visited;
    static List<int[]> list;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ans;

    //갯수 세기
    static int getArea() {

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && visited[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    static void check(int y, int x, int dir, int watched) {
        int ny = y;
        int nx = x;

        while(true) {
            ny += dy[dir];
            nx += dx[dir];
            //범위 체크
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) break;
            //벽은 뚫을 수 없음
            if (arr[ny][nx] == 6) break;
            //cctv는 뛰어넘어도 상관없음
            visited[ny][nx] += watched;
            
        }
    }

    //방문체크 하기
    static void watch(int type, int y, int x, int dir, int watched) {
        //dir : 상 우 하 좌
        int ny = y;
        int nx = x;

        //특수 케이스 : dfs에 포함 안함
        if (type == 5) {
            for (int d = 0; d < 4; d++) {
                check(ny, nx, d, watched);
            }
            return;
        }

        //default : 원래 방향 1
        check(ny, nx, dir, watched);
        //type == 2 or 4
        if (type % 2 == 0) {
            check(ny, nx, (dir + 2) % 4, watched);
        }
        //type == 3 or 4
        if (type >= 3) {
            check(ny, nx, (dir + 1) % 4, watched);
        }
        
    }

    static void solve(int idx) {

        if (idx == list.size()) {
            ans = Math.min(ans, getArea());
            return;
        }

        int type = list.get(idx)[0];
        int y = list.get(idx)[1];
        int x = list.get(idx)[2];

        //dir 돌리면서 4방향으로 watch
        for (int dir = 0; dir < 4; dir++) {
            //2일때는 2번만
            if (type == 2 && dir > 1) break;
            watch(type, y, x, dir, 1);
            solve(idx + 1);
            watch(type, y, x, dir, -1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new int[n][m];
        list = new ArrayList<>();
        List<int[]> five = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] >= 1 && arr[i][j] <= 4) {
                    list.add(new int[] {arr[i][j], i, j});
                } else if (arr[i][j] == 5) {
                    five.add(new int[] {arr[i][j], i, j});
                }
            }
        }

        for (int cur[] : five) watch(5, cur[1], cur[2], 0, 1);

        ans = Integer.MAX_VALUE;

        if (list.isEmpty()) ans = Math.min(ans, getArea());
        else solve(0);

        System.out.println(ans);
    }
}
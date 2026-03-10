import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static List<int[]> chicken_list;
    static List<int[]> home;
    static boolean[] selected;
    static int ans;

    static int getChickenDist() {
        int totalCityDist = 0;

        // 1. 모든 집을 하나씩 확인
        for (int[] h : home) {
            int minHomeDist = Integer.MAX_VALUE;
            
            // 2. 선택된 치킨집들 중 가장 가까운 거리 찾기
            for (int i = 0; i < chicken_list.size(); i++) {
                if (selected[i]) { // 선택된 치킨집만 계산
                    int[] c = chicken_list.get(i);
                    int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    minHomeDist = Math.min(minHomeDist, dist);
                }
            }
            totalCityDist += minHomeDist;
        }
        return totalCityDist;
    }

    static void solve(int idx, int cnt) {

        if (cnt == m) {
            ans = Math.min(ans, getChickenDist());
            return;
        }

        for (int i = idx; i < chicken_list.size(); i++) {
            selected[i] = true;
            solve(i + 1, cnt + 1);
            selected[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        chicken_list = new ArrayList<>();
        home = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) home.add(new int[] {i, j});
                else if (arr[i][j] == 2) chicken_list.add(new int[]{i, j, 0});
            }
        }

        selected = new boolean[chicken_list.size()];
        
        ans = Integer.MAX_VALUE;

        solve(0, 0);

        System.out.println(ans);
    }

}
import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] chess;
    static boolean[] bishop; //좌상향 대각선 겹침 여부
    static int tempMax;

    //우상향 대각선별로 하나씩 놓아보기
    static void dfs(int pos, int count) {

        if (pos >= 2 * n - 1) {
            tempMax = Math.max(tempMax, count);
            return;
        }

        int maxRow = (pos >= n - 1) ? n - 1 : pos;
        int minRow = (pos >= n - 1) ? (pos - n + 1) : 0;

        //대각선 탐사
        for (int i = maxRow; i >= minRow; i--) {
            int y = i;
            int x = pos - i;
            //0인 곳은 탐사 불가
            if (chess[y][x] == 0) continue;
            //대각선 겹치면 탐사 불가
            if (bishop[y - x + n - 1]) continue;
            //탐사
            bishop[y - x + n - 1] = true;
            dfs(pos + 2, count + 1);
            bishop[y - x + n - 1] = false;
        }

        dfs(pos + 2, count);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        chess = new int[n][n];
        bishop = new boolean[n * 2 - 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                chess[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tempMax = 0;

        dfs(0, 0);
        int blackCount = tempMax; //시작 : 0번째
        tempMax = 0;
        dfs(1, 0);
        int whiteCount = tempMax; // 시작 : 1번째

        System.out.println(blackCount + whiteCount);
        
    }
}
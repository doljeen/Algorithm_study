import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] arr;
    static int[][][] dp;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][3];
        dp = new int[n + 1][3][3];
        
        for (int i = 1; i <= n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < 3; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for (int i = 1; i <= n; i++) {
        	for (int j = 0; j < 3; j++) {
        		Arrays.fill(dp[i][j], 10_000_001);
        	}
        }
        
        dp[1][0][0] = arr[1][0];
        dp[1][1][1] = arr[1][1];
        dp[1][2][2] = arr[1][2];

        
        for (int i = 2; i <= n; i++) {
        	for (int j = 0; j < 3; j++) {
        		for (int k = 0; k < 3; k++) {
        			dp[i][j][k] = Math.min(dp[i - 1][(j + 1) % 3][k] + arr[i][j],
        					dp[i - 1][(j + 2) % 3][k] + arr[i][j]);
        		}
        	}
        }
        
        
        int ans = 10_000_001;
        for (int i = 0; i < 3; i++) {
        	ans = Math.min(ans, Math.min(dp[n][i][(i + 1) % 3], dp[n][i][(i + 2) % 3]));
        }
        
        System.out.println(ans);
        
    }

}
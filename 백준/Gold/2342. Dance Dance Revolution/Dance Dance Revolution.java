import java.util.*;

public class Main {
    static final int INF = 400001; // 최대 10만번 * 4점 = 40만
    
    static int getCost(int from, int to) {
        if (from == 0) return 2;
        if (from == to) return 1;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> commands = new ArrayList<>();
        while (true) {
            int cmd = sc.nextInt();
            if (cmd == 0) break;
            commands.add(cmd);
        }

        int n = commands.size();
        // dp[단계][왼발][오른발]
        int[][][] dp = new int[n + 1][5][5];

        // 모든 값을 무한대로 초기화
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        // 시작점 설정 (0번째 명령 수행 전, 양발은 0에 있음)
        dp[0][0][0] = 0;

        for (int i = 0; i < n; i++) {
            int target = commands.get(i); // 현재 밟아야 할 발판

            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    int currentDist = dp[i][l][r];
                    if (currentDist == INF) continue; // 불가능한 상태는 건너뜀

                    // 1. 왼발을 target으로 옮기는 경우 (오른발과 겹치지 않을 때만)
                    if (target != r) {
                        dp[i + 1][target][r] = Math.min(dp[i + 1][target][r], 
                                               currentDist + getCost(l, target));
                    }

                    // 2. 오른발을 target으로 옮기는 경우 (왼발과 겹치지 않을 때만)
                    if (target != l) {
                        dp[i + 1][l][target] = Math.min(dp[i + 1][l][target], 
                                               currentDist + getCost(r, target));
                    }
                }
            }
        }

        // 결과 찾기: n번째 단계를 마친 후 모든 발 위치 중 최솟값
        int result = INF;
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                result = Math.min(result, dp[n][l][r]);
            }
        }
        System.out.println(result);
    }
}
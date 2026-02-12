import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[102][102];
        for(int i = 0; i < N; i++) {
            int r = sc.nextInt(); // x좌표
            int c = sc.nextInt(); // y좌표
            // 종이 크기(10x10)만큼 도화지를 1로 색칠함
            for(int s = r; s < r+10; s++) {
                for(int e = c; e < c+10; e++) {
                    // 이미 1인 곳(다른 종이가 붙은 곳)은 무시, 0인 곳만 1로 바꿈
                    if(arr[s][e] == 0) {
                        arr[s][e] = 1;
                    }
                }
            }
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int sum = 0;
    	for(int i = 1; i < 102; i++) {
    		for(int j = 1; j < 102; j++) {
    			for(int dir = 0; dir < 4; dir++) {
    				int nx = i + dx[dir];
    				int ny = j + dy[dir];
    				if(nx >= 102 || ny >= 102 || nx < 0 || ny < 0) continue;
    				if(arr[i][j] == 1 && arr[nx][ny] == 0) {
    					sum += arr[i][j];
    				}
    			}
    		}
        }
    	System.out.println(sum);
    }
}
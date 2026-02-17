import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static int N, M;
	public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arr = new int[N][N];
        for(int i = 0; i < M ; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken()) - 1;
        	int v = Integer.parseInt(st.nextToken()) - 1;
        	arr[u][v] = 1;
        	arr[v][u] = 1;
        }
        dfs(0);
        int count = 0;
        for(int i = 0; i < N; i++) {
        	if(visited[i] == true) count++;
        }
        System.out.println(count - 1);
    }
    public static void dfs(int current) {
    	visited[current] = true;
    	for(int i = 0; i < N; i++) {
    		if(arr[current][i] == 1 && !visited[i]) {
    			dfs(i);
    		}
    	}
    }
}
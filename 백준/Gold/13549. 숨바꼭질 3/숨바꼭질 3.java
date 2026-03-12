import java.util.*;
import java.io.*;

public class Main {

    static int n, k;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        visited = new int[100001];
        
        q.add(new int[] {n, 0});
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[n] = 0;
        
        int ans = 0;
        
        while(!q.isEmpty()) {
        	int cur[] = q.poll();
        	int num = cur[0];
        	int time = cur[1];
        	if (num == k) {
        		ans = time;
        		break;
        	}
        	
        	if (num > 0) {
        		if (visited[num - 1] > time + 1) {
        			visited[num - 1] = time + 1;
        			q.add(new int[] {num - 1, time + 1});
        		}
        	}
        	if (num < 100000) {
        		if (visited[num + 1] > time + 1) {
        			visited[num + 1] = time + 1;
        			q.add(new int[] {num + 1, time + 1});
        		}
        	}
        	if (num > 0 && num * 2 <= 100000) {
        		if (visited[num * 2] > time) {
        			visited[num * 2] = time;
        			q.add(new int[] {num * 2, time});
        		}
        	}
        }
        
        System.out.println(ans);
        
    }
    
}
import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Node>[] graph;
    static List<Node>[] reverse_graph;
    static int[] dp;
    static int[] indegree;
    static boolean[] visited;
    static int start, end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        dp = new int[n + 1];
        indegree = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<Node>();
        reverse_graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) reverse_graph[i] = new ArrayList<Node>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
            reverse_graph[v].add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.weight, a.weight));
        
        pq.add(new Node(start, 0));
        Arrays.fill(dp, -1);
        dp[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dp[cur.num] > cur.weight) continue;
            dp[cur.num] = cur.weight;
            
            for (Node nxt : graph[cur.num]) {
                if (dp[nxt.num] < dp[cur.num] + nxt.weight) {
                    dp[nxt.num] = dp[cur.num] + nxt.weight;
                    pq.add(new Node(nxt.num, dp[nxt.num]));
                }
            }
        }
        System.out.println(dp[end]);        
        
        Queue<Integer> rq = new ArrayDeque<>();
        rq.add(end);
        visited = new boolean[n + 1];
        visited[end] = true;

        int roadCount = 0;
        while (!rq.isEmpty()) {
            int cur = rq.poll();

            for (Node next : reverse_graph[cur]) {
                // 임계 경로에 포함되는 도로인지 확인
                if (dp[cur] == dp[next.num] + next.weight) {
                    roadCount++;
                    
                    if (!visited[next.num]) {
                        visited[next.num] = true;
                        rq.add(next.num);
                    }
                }
            }
        }

        System.out.println(roadCount);

    }

    static class Node {
        int num;
        int weight;
        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}
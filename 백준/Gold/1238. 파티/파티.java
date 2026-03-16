import java.util.*;
import java.io.*;

public class Main {

    static int n, m, x;
    static List<int[]>[] graph;
    static List<int[]>[] reverse_graph;
    static boolean[] visited;
    static int[] dist;
    static int[] reverse_dist;

    static void dijkstra(int start, List<int[]>[] list, int[] d) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        pq.add(new int[] {start, 0});
        d[start] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cur_d = cur[1];

            if (visited[node]) continue;
            visited[node] = true;

            for (int[] nxt : list[node]) {

                if (d[nxt[0]] > cur_d + nxt[1]) {
                    d[nxt[0]] = cur_d + nxt[1];
                    pq.add(new int[] {nxt[0], d[nxt[0]]});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        reverse_graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        reverse_dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverse_graph[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(reverse_dist, Integer.MAX_VALUE);
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, t});
            reverse_graph[v].add(new int[] {u, t});
        }

        dijkstra(x, graph, dist);
        Arrays.fill(visited, false);
        dijkstra(x, reverse_graph, reverse_dist);

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i] + reverse_dist[i]);
        }

        System.out.println(ans);
        
    }

}
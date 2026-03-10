import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] graph;
    static int[] parent;

    static void union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[m][3];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) parent[i] = i;

        int cost = 0;
        int maxCost = 0;

        for (int i = 0; i < graph.length; i++) {
            if (findParent(graph[i][0]) != findParent(graph[i][1])) {
                cost += graph[i][2];
                maxCost = Math.max(maxCost, graph[i][2]);
                union(graph[i][0], graph[i][1]);
            }
        }

        System.out.println(cost - maxCost);
    }
}
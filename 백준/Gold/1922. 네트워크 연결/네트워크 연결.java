import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int E;
    static Node[] vertices;
    static int[] parent;


    static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    static boolean union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a == b) return false;

        if (a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(br.readLine().trim());

        vertices = new Node[E];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            vertices[i] = new Node(u, v, cost);
        }

        Arrays.sort(vertices, (a, b) -> Integer.compare(a.cost, b.cost));

        long maxWeight = 0;

        for (int i = 0; i < E; i++) {
            int a = vertices[i].u;
            int b = vertices[i].v;
            if (union(a, b)) {
                maxWeight += vertices[i].cost;
            }
        }
        
        System.out.println(maxWeight);
    }

    static class Node {
        int u;
        int v;
        int cost;
        Node(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }
}
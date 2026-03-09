import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean found = false; // 찾았는지 여부 플래그

    static void dfs(int node, int depth) {
        if (depth == 4) { // 친구 관계가 5명(간선 4개) 연결됨
            found = true;
            return;
        }

        for (int next : graph[node]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
                if (found) return; // 찾았으면 즉시 탈출
                visited[next] = false; // 백트래킹
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, 0); // 각 노드를 시작점으로 한 번씩 다 찔러봄
            visited[i] = false; // 중요: 시작점 백트래킹
            
            if (found) break; // 찾았으면 끝
        }

        System.out.println(found ? 1 : 0);
    }
}
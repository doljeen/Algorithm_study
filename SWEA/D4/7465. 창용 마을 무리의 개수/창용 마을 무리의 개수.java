import java.util.*;
import java.io.*;

class Solution
{

    static int n, m;
    static int[] parent;
    static Integer[] rank;

    static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    static boolean union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        //부모가 같은 경우
        if (x == y) return false;

        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else parent[y] = x;

        if (rank[x] == rank[y]) rank[x]++;

        return true;
    }

	public static void main(String args[]) throws Exception
	{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            parent = new int[n + 1];
            rank = new Integer[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            Set<Integer> roots = new HashSet<>();

            for (int i = 1; i <= n; i++) roots.add(findParent(i));

            System.out.println("#" + test_case + " " + roots.size());
		}
	}
}
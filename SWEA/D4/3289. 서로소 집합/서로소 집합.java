import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution
{

    static int n, m;
    static int[] parent;
    static int[] rank;

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
            StringBuilder sb = new StringBuilder();

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            sb.append("#").append(test_case).append(" ");

            for (int query = 0; query < m; query++) {
                st = new StringTokenizer(br.readLine());
                int q = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                //합치기
                if (q == 0) {
                    union(a, b);
                }
                else {
                    sb.append(findParent(a) == findParent(b) ? 1 : 0);
                }
            }

            System.out.println(sb);
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int V, E;
	public static pair[] arr;
	public static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		arr = new pair[E];
		parents = new int[V];
		for(int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int value = Integer.parseInt(st.nextToken());
			arr[i] = new pair(start, end, value);
		}
		Arrays.sort(arr);
		makeSet();
		int result = 0;
		int cnt = 0;
		for(pair p : arr) {
			if(union(p.start, p.end)) {
				result += p.weight;
				if(++cnt == V-1) break;
			}
		}
		System.out.println(result);
		
		
	}
	
	public static void makeSet() {
		for(int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static class pair implements Comparable<pair>{
		int start;
		int end;
		int weight;
		
		public pair(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(pair o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}

}

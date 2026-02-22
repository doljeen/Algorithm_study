
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[] visited;
    public static int result, count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int depth = 0;
        result = 0;
        count = 0;
        visited = new int[100001]; // 0 ~ 100000 범위 방문 체크
        for(int i = 0; i < 100001; i++) {
        	visited[i] = -1;
        }
        bfs(N, K, depth);
        
        System.out.println(result + "\n" + count);
    }
    
    public static void bfs(int start, int target, int depth) {
    	int min = Integer.MAX_VALUE;
    	visited[start] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            // 목표 위치에 도달하면 이동 횟수 반환
            
            if(current == target) {
            	result = visited[current];
                count++;
                if (visited[current] > result) break;
            }
            
            // 이동 가능한 세 가지 경우
            int minus = current-1;
            int plus = current+1;
            int multi = current*2;
            
            // -1 이동 (범위 체크 + 방문 안 한 경우)
            if(minus >= 0) {
            	if(visited[minus] == -1) {
            		visited[minus] = visited[current]+1;
            		queue.offer(minus);            		
            	}else if(visited[minus] == visited[current] + 1) {
            		visited[minus] = visited[current]+1;
            		queue.offer(minus);            		
            	}
            }
            
            // +1 이동
            if(plus <= 100000) {
            	if(visited[plus] == -1) {
            		queue.offer(plus);
            		visited[plus] = visited[current]+1;
            	}else if(visited[plus] == visited[current] + 1) {
            		visited[plus] = visited[current]+1;
            		queue.offer(plus);            		
            	}
                
            }
            // *2 이동
            if(multi > 0 && multi <= 100000) {
            	if(visited[multi] == -1) {
            		visited[multi] = visited[current]+1;
            		queue.offer(multi);            		
            	}else if(visited[multi] == visited[current] + 1) {
            		visited[multi] = visited[current]+1;
            		queue.offer(multi);            		
            	}
                
            }
        }
    }
}

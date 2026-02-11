import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        List<Integer> list = new ArrayList<>();
        for(int i =0; i < N; i++) {
        	arr[i] = sc.nextInt();
        }
        int j = 0;
        for(int i = 0; i < N; i++) {
        	int left = i-1;
        	int right = i+1;
        	if(i == 0) {
        		if(right >= N || arr[i] >= arr[right]) {
        			list.add(i+1);
        		} 
        	}else if(i == N-1) {
        		if(arr[i] >= arr[left]) {
        			list.add(i+1);
        		}
        	}else {
        		if((arr[i] >= arr[right] && arr[i] >= arr[left])) {
            		list.add(i+1);
            	}
        	}
        }
        for(int i = 0; i < list.size(); i++) {
        	System.out.println(list.get(i));        	
        }
    }
}
import java.io.IOException;
import java.util.Scanner;

// 백준 p15684 사다리 조작
public class Main {

    static int[] arr;
    static int max, nanjang;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
    	max = 0;
    	Scanner sc = new Scanner(System.in);
    	arr = new int[9];
    	isSelected = new boolean[9];
    	for(int i = 0; i < 9; i++) {
    		arr[i] = sc.nextInt();
    	}
    	hap(0, 0, 0);
       
    }
    
    public static void hap(int idx, int sum, int cnt) {
    	if(sum > 100) return;
    	if(idx == 9) {
    		if(sum == 100 && cnt == 7) {
	    		for(int i = 0; i < 9; i++) {
	    			if(isSelected[i])
	    				System.out.println(arr[i]);
				}
	    		
    		}
    		return;
    	}
    	isSelected[idx] = true;
    	hap(idx+1, sum+arr[idx], cnt+1);
    	isSelected[idx] = false;
    	hap(idx+1, sum, cnt);
    	
    }
}
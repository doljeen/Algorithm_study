import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> arr = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
        	for(int j = 1; j <= 9; j++) {
        		for(int k = 1; k <= 9; k++) {
        			if(i==j || i == k || j == k) {
        				continue;
        			}
        			arr.add(""+i + j + k);
        		}
        	}
        }
        int N = sc.nextInt();
        String[] str = new String[N];
        int[] strike = new int[N];
        int[] ball = new int[N];
        int cnt = 0;
        for(int i = 0; i < N; i++) {
        	str[i] = sc.next();
        	strike[i] = sc.nextInt();
        	ball[i] = sc.nextInt();
        }
        
        for(int j = 0; j < N; j++) {
        	for(int i =0; i < arr.size(); i++) {
        		int st = 0;
        		int ba = 0;
        		
        		for(int k = 0; k < 3; k++) {
        			if(arr.get(i).charAt(k) == str[j].charAt(k)) {
            			st++;
            		}
        			if(str[j].contains(""+arr.get(i).charAt(k))) {
            			ba++;
            		}
        		}
        		ba -= st;
        		if(strike[j] != st || ball[j] != ba) {
        			arr.remove(i);
        			i--;
        		}
        	}
        }
        cnt = arr.size();
        System.out.println(cnt);
        

        
    }
}

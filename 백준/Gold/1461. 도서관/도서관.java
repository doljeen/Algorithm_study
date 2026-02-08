import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int max = 0;
        int result = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	if(tmp < 0) {
        		left.add(tmp);
        	}else if(tmp > 0)
        		right.add(tmp);
        	if(Math.abs(tmp) > max) max = Math.abs(tmp);
        }
        Collections.sort(left);
        Collections.sort(right);
        for(int i = 0; i < left.size(); i += M) {
        	result += (Math.abs(left.get(i)) * 2);
        }
        for(int i = right.size()-1; i >= 0; i -= M) {
        	result += (Math.abs(right.get(i)) * 2);
        }
        result -= max;
        
        System.out.println(result);
        
    }
}
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

        int N = Integer.parseInt(br.readLine());
        int bit = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String str = st.nextToken();
        	if(str.equals("add")) {
        		int x = Integer.parseInt(st.nextToken());
        		bit |= 1 << (x-1);
        	} else if(str.equals("remove")) {
        		int x = Integer.parseInt(st.nextToken());
        		bit &= ~(1 << (x-1));
        	} else if(str.equals("check")) {
        		int x = Integer.parseInt(st.nextToken());
        		sb.append(((bit >> (x-1)) & 1)).append('\n');
        	} else if(str.equals("toggle")){
        		int x = Integer.parseInt(st.nextToken());
        		bit ^= 1 << (x-1);
        	} else if(str.equals("all")){
        		bit = (1 << 20) - 1;
        	}else if(str.equals("empty")){
        		bit = 0;
        	}
        }
        	System.out.println(sb);
        
    }
}
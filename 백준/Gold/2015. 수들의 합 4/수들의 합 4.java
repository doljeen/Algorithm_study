import java.io.*;
import java.util.*;

public class Main {

    static final int OFFSET = 20000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[OFFSET * 2 + 1];

        int sum = 0;
        long answer = 0;

        count[OFFSET] = 1;

        for(int i = 0; i < N; i++){
            sum += arr[i];

            int target = sum - K;

            if(target + OFFSET >= 0 && target + OFFSET < count.length){
                answer += count[target + OFFSET];
            }

            count[sum + OFFSET]++;
        }

        System.out.println(answer);
    }
}
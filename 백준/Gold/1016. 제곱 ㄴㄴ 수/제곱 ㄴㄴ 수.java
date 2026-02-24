import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long M = sc.nextLong();

        int size = (int)(M - N + 1);
        boolean[] checked = new boolean[size]; 
        
        for (long i = 2; i * i <= M; i++) {
            long square = i * i;

            long start = ((N + square - 1) / square) * square;

            for (long x = start; x <= M; x += square) {
                int idx = (int)(x - N);
                checked[idx] = true;
            }
        }

        long count = 0;
        for (int i = 0; i < size; i++) {
            if (!checked[i]) count++;
        }

        System.out.println(count);
    }
}
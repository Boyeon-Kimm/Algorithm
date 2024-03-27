import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        int[] price = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        Arrays.sort(price);
        long left = 0;
        long right = price[N - 1];
        long answer = 0;

        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for(int p : price) {
                if(mid < p) sum += mid;
                else sum += p;
            }

            if(sum <= M) {
                answer = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        System.out.println(answer);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lan = new int[K];

        for(int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);
        long left = 1;
        long right = (long)lan[K - 1] + 1;
        long answer = 0;

        while(left < right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for(int l : lan) {
                sum += l / mid;
            }

            if(sum >= N) {
                answer = mid;
                left = mid + 1;
            } else right = mid;
        }
        System.out.println(answer);
    }
}
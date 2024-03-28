import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] times = new int[N];
        long max = Long.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, times[i]);
        }

        Arrays.sort(times);
        long left = 1;
        long right = (long) M * max;
        long answer = Long.MAX_VALUE;

        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for(int time : times) {
                sum += mid / time;
                if(sum >= M) break;
            }

            if(sum >= M) {
                answer = Math.min(mid, answer);
                right = mid - 1;
            } else left = mid + 1;
        }
        System.out.println(answer);
    }
}
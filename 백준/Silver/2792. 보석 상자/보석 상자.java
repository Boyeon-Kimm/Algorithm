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
        int[] jewels = new int[M];
        long answer = 0;

        for(int i = 0; i < M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels);
        int left = 1;
        int right = jewels[M - 1];
        while(left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for(int jewel : jewels) {
                sum += (jewel + mid - 1) / mid;
            }

            if(sum <= N) {
                answer = mid;
                right = mid - 1;
            } else left = mid + 1;
        }

        System.out.println(answer);
    }
}
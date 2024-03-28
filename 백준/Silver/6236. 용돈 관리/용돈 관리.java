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
        int[] account = new int[N];

        for(int i = 0; i < N; i++) {
            account[i] = Integer.parseInt(br.readLine());
        }

        int left = Arrays.stream(account).max().getAsInt();
        int right = Arrays.stream(account).sum();
        int K = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            int count = 1;

            for(int money : account) {
                if(sum + money > mid) {
                    count++;
                    sum = 0;
                }
                sum += money;
            }

            if(count <= M) {
                right = mid - 1;
                K = mid;
            } else left = mid + 1;
        }
        System.out.println(K);
    }
}

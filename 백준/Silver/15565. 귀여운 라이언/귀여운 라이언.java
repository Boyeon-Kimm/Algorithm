import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] doll = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            doll[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, count = 0, min = Integer.MAX_VALUE;

        while(right < N) {
            if(doll[right] == 1) count++;

            while(count >= K) {
                min = Math.min(min, right - left + 1);
                if(doll[left] == 1) count--;
                left++;
            }
            right++;
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
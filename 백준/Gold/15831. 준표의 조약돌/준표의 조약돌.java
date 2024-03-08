import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int solution(int N, int B, int W, char[] arr) {
        int lt = 0, rt = 0;
        int max = 0;
        int[] stone = new int[2];

        while(rt < N) {
            if(arr[rt] == 'B') stone[1]++;
            else stone[0]++;

            if(B < stone[1]) {
                if(arr[lt] == 'B') stone[1]--;
                else stone[0]--;
                lt++;
            }
            if(stone[0] >= W) max = Math.max(max, rt - lt + 1);
            rt++;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Main T = new Main();

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();

        System.out.println(T.solution(N, B, W, arr));
    }
}
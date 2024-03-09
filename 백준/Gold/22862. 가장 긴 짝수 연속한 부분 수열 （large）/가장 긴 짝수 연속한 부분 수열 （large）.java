import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public int solution(int N, int K, int[] S) {
        int answer = 0, lt = 0, cnt = 0;
        for(int rt = 0; rt < N; rt++) {
            if(S[rt] % 2 != 0) cnt++;

            while(cnt > K) {
                if(S[lt] % 2 != 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1 - cnt);
        }
        return answer;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Main T = new Main();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] S = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(N, K, S));
    }

}
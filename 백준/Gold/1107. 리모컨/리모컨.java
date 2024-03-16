import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];

        if(N == 100) {
            System.out.println(0);
            return;
        }

        int answer = Math.abs(N - 100);

        if(M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        for(int i = 0; i < 1000000; i++) {
            String num = String.valueOf(i);
            boolean flag = false;
            for(int j = 0; j < num.length(); j++) {
                if(broken[num.charAt(j) - '0']) {
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                int result = Math.abs(N - i) + num.length();
                answer = Math.min(result, answer);
            }
        }
        System.out.println(answer);
    }
}
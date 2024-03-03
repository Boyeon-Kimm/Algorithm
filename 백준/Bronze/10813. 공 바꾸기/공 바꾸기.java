import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] basket = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            basket[i] = i;
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            int temp = basket[first];
            basket[first] = basket[second];
            basket[second] = temp;
        }

        for(int i = 1; i <= N; i++) {
            sb.append(basket[i]).append(" ");
        }
        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(tc-- > 0) {
            String answer = "YES";
            int N = Integer.parseInt(br.readLine());
            String[] phone_book = new String[N];
            for(int i = 0; i < N; i++) {
                phone_book[i] = br.readLine();
            }

            Arrays.sort(phone_book);

            for(int i = 0; i < phone_book.length - 1; i++) {
                if(phone_book[i + 1].startsWith(phone_book[i])) {
                    answer = "NO";
                    break;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
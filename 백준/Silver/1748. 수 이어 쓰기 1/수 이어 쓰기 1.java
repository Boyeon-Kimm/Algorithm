import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int upgrade = 1;
        int num = 10;

        for(int i = 1; i <= N; i++) {
            if(i % num == 0) {
                upgrade++;
                num *= 10;
            }
            count += upgrade;
        }

        System.out.println(count);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int i = 1; i <= tc; i++) {
            String[] arr = br.readLine().split(" ");
            sb.append("Case ").append("#").append(i).append(": ");
            for(int j = arr.length - 1; j >= 0; j--) {
                if(j == 0) sb.append(arr[j]).append("\n");
                else sb.append(arr[j]).append(" ");
            }
        }
        System.out.println(sb);
    }
}
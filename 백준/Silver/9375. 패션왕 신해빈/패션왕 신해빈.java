import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < N; i++) {
                String[] clothes = br.readLine().split(" ");
                map.put(clothes[1], map.getOrDefault(clothes[1], 0) + 1);
            }

            int answer = 1;
            for(int value : map.values()) {
                answer *= (value + 1);
            }
            System.out.println(answer - 1);
        }
    }
}
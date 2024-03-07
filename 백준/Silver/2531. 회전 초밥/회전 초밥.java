import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for(int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(c, 1);
        for(int i = 0; i < k; i++) {
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
        }
        int max = map.size();
        for(int i = k; i < N + k; i++) {
            map.put(sushi[i % N], map.getOrDefault(sushi[i % N], 0) + 1);
            map.put(sushi[(i - k) % N], map.getOrDefault(sushi[(i - k) % N], 0) - 1);
            if(map.get(sushi[i - k]) == 0) {
                map.remove(sushi[i - k]);
            }
            max = Math.max(max, map.size());
        }
        System.out.println(max);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Character, Integer> map = new HashMap<>();

        while(N-- > 0) {
            char ch = br.readLine().charAt(0);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= 5) sb.append(entry.getKey());
        }
        System.out.println(sb.length() == 0 ? "PREDAJA" : sb.toString());
    }
}
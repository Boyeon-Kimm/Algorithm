import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Map<Long, Integer> map = new HashMap<>();
		
		int max = Integer.MIN_VALUE;
		long card = 0;
		for(int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			
			map.put(num, map.getOrDefault(num, 0) + 1);
			
			if(map.get(num) > max) {
				max = map.get(num);
				card = num;
			} else if(map.get(num) == max) {
				card = Math.min(card, num);
			}
		}
		System.out.println(card);
	}
}
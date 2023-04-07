import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> monster = new HashMap<>();
		HashMap<String, Integer> monster2 = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			String mon = br.readLine();
			monster.put(i, mon);
			monster2.put(mon, i);
		}
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			try {
				int num = Integer.parseInt(str);
				sb.append(monster.get(num)).append("\n");
			} catch (Exception n) {
				sb.append(monster2.get(str)).append("\n");
			}
		}
		System.out.println(sb);
	}
}
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
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Boolean> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			map.put(br.readLine(), true);
		}
		
		int cnt = N;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			while(st.hasMoreTokens()) {
				String str = st.nextToken();
				if(map.containsKey(str)) {
					map.remove(str);
					cnt--;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		Map<String, String> map = new HashMap<>();
		Map<String, String[]> arrMap = new HashMap<>();
		
		while(N-- > 0) {
			String team = br.readLine();
			int num = Integer.parseInt(br.readLine());
			String[] arr = new String[num];
			
			for(int i = 0; i < num; i++) {
				String gName = br.readLine();
				arr[i] = gName;
				map.put(gName, team);
			}
			Arrays.sort(arr);
			arrMap.put(team, arr);
		}

		StringBuilder sb = new StringBuilder();
		while(M-- > 0) {
			String quiz = br.readLine();
			int type = Integer.parseInt(br.readLine());
			switch(type) {
			case 0:
				for(String s : arrMap.get(quiz)) 
					sb.append(s).append("\n");
				
				break;
				
			case 1:
				sb.append(map.get(quiz)).append("\n");
				break;
				
			}
		}
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String[] str = st.nextToken().split("");
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < str.length; i++) {
				for(int j = 0; j < R; j++) {
					sb.append(str[i]);
				}
			}
			System.out.println(sb);
		}
	}
}

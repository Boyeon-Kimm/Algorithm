import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		String ans = "";
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			
			if(min > num) {
				min = num;
				ans = str;
			}
		}
		System.out.println(ans);
	}
}
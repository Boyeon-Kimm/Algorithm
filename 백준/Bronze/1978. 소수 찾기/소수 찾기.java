import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int tc = 0; tc < N; tc++) {
			int num = Integer.parseInt(st.nextToken());
			
			for(int i = 2; i <= num; i++) {
				if(num == i) cnt++;
				
				if(num % i == 0) break;
			}
		}
		System.out.println(cnt);
	}
}
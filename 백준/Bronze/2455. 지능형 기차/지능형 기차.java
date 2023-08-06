import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int people = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			
			people += in;
			people -= out;
			
			max = Math.max(max, people);
		}
		System.out.println(max);
	}
}

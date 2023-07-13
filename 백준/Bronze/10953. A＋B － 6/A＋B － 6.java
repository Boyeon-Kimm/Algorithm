import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String[] str = br.readLine().split(",");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
		
			sb.append(a + b).append("\n");
		}
		System.out.println(sb);
	}
}
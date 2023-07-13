import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split("");
		
		for(int i = 0; i < str.length; i++) {
			sb.append(str[i]);
			if((i + 1) % 10 == 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
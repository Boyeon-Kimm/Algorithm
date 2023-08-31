import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		
		while(true) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) break;
			else if(num % 2 == 0) sb.append(tc).append(". ").append("even ").append(num / 2).append("\n");
			else sb.append(tc).append(". ").append("odd ").append(num / 2).append("\n");
			
			tc++;
		}
		System.out.println(sb);
	}
}
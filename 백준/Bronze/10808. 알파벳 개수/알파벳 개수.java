import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] arr = new int[26];
		
		for(int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - '0';
			arr[num - 49]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int n : arr) {
			sb.append(n).append(" ");
		}
		System.out.println(sb);
	}
}
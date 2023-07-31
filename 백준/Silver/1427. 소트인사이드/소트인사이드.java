import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] arr = new char[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			arr[i] = ch;
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		
		for(int i = str.length() - 1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}
}
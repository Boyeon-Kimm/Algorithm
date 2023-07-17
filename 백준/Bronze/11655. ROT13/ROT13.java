import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(!Character.isLetter(c)) {
				sb.append(c);
				continue;
			}
			int num = (int)c + 13;
			
			if(Character.isUpperCase(c) && num > 90) {
				num -= 26;
			}
			
			if(Character.isLowerCase(c) && num > 122) {
				num -= 26;
			}
			sb.append((char)num);
		}
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String pattern = br.readLine();
		int cnt = 0; 
		
		for(int i = 0; i <= str.length() - pattern.length(); i++) {
			boolean flag = true;
			
			for(int j = 0; j < pattern.length(); j++) {
				if(str.charAt(i + j) != pattern.charAt(j)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				cnt++;
				i += pattern.length() - 1;
			}
		}
		System.out.println(cnt);
	}
}
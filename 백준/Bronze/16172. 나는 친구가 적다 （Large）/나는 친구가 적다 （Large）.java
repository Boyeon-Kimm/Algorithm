import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String parent = br.readLine().replaceAll("[0-9]", "");
		String pattern = br.readLine();
		
		System.out.println(KMP(parent, pattern) ? 1 : 0);
	}
	
	static boolean KMP(String parent, String pattern) {
		int[] table = makeTable(pattern);
		
		int pLen = parent.length();
		int nLen = pattern.length();
		
		int idx = 0;
		for(int i = 0; i < pLen; i++) {
			while(idx > 0 && parent.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx - 1];
			}
			
			if(parent.charAt(i) == pattern.charAt(idx)) {
				if(idx == nLen - 1) {
					idx = table[idx];
					return true;
				} else {
					idx++;
				}
			}
		}
		return false;
	}

	private static int[] makeTable(String pattern) {
		int n = pattern.length();
		int[] table = new int[n];
		
		int idx = 0;
		for(int i = 1; i < n; i++) {
			while(idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx - 1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(idx)) {
				table[i] = ++idx;
				
			}
		}
		return table;
	}
}
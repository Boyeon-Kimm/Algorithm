import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		int[] ans = new int[26];
		Arrays.fill(ans, -1);
		
		for(int i = 0; i < ch.length; i++) {
			if(ans[ch[i]-'0'-49] != -1) continue;
			ans[ch[i]-'0'-49] = i;
		}
		
		for(int a : ans)
			System.out.print(a + " ");
	}
}
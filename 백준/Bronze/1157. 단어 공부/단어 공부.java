import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] alphabet = new int[26];
		String str = sc.nextLine().toUpperCase();
		
		for(int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - 65;
			alphabet[num]++;
		}
		
		int max = Integer.MIN_VALUE;
		char ch = '?';
		for(int i = 0; i < 26; i++) {
			if(max < alphabet[i]) {
				max = alphabet[i];
				ch = (char)(i + 65);
			} else if(max == alphabet[i]) {
				ch = '?';
			}
		}
		System.out.println(ch);
	}
}
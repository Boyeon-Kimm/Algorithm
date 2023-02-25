import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		int T = Integer.parseInt(num);

		for(int tc = 1; tc <= T; tc++) {
			char[] word = sc.next().toCharArray();
			boolean flag = true;
			for(int i = 0; i < word.length / 2; i++) {
				if(word[i] != word[word.length - i - 1])
					flag = false;
					break;
			}
			if(flag == false) System.out.println("#"+tc+" "+0);
			else System.out.println("#"+tc+" "+1);
		}
	}
}
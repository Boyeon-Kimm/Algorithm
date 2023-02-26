import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			String num = sc.next();
			int num2 = Integer.parseInt(num);
			char[] p = sc.next().toCharArray();
			char[] sen = sc.next().toCharArray();
			
			int n = sen.length;
			int m = p.length;
			int count = 0;
			
			for(int i = 0; i < n - m + 1; i++) {
				boolean flag = true;
				for(int j = 0; j < m; j++) {
					if(p[j] != sen[i+j]) {
						flag = false;
						break;
					}
				}
				if(flag == true) count++;
			}
			System.out.println("#"+tc+" "+count);
		}
	}
}
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			int[][] table = new int[100][100];
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			int cnt = 0;
			for(int i = 0; i < 100; i++) {
				boolean flag = true;
				for(int j = 0; j < 100; j++) {
					if(table[j][i] == 0) continue;
					else if(table[j][i] == 1) flag = false;
					else if(table[j][i] == 2 && flag == false) {
						cnt++;
						flag = true;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
}
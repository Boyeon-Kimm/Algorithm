import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; i <= 10; i++) {
			int tc = sc.nextInt();
			int[][] map = new int[100][102];
			int x = 0;
			int y = 0;

			for(int j = 0; j < 100; j++) {
				for(int k = 1; k < 101; k++) {
					map[j][k] = sc.nextInt();
					if(map[j][k] == 2) {
						x = j;
						y = k;
					}
				}
			}
			while(x != 0){
				if(map[x][y-1] == 1) {
					map[x][y-1] = 0;
					y = y - 1;
				} else if(map[x][y+1] == 1) {
					map[x][y+1] = 0;
					y = y + 1;
				} else if(map[x-1][y] == 1){
					map[x-1][y] = 0;
					x = x - 1;
				}
			}
			int answer = y - 1;
			System.out.println("#"+i+" "+answer);
		}
	}
}
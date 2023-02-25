import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			int x = 0;
			int y = 0;
			int d = 0;
            
			for(int i = 1; i <= N * N; i++) {
				snail[x][y] = i;
				x += dr[d];
				y += dc[d];
                
				if(x < 0 || x >= N || y < 0 || y >= N || snail[x][y] > 0) {
					x -= dr[d];
					y -= dc[d];
					d = ( d + 1 ) % 4;
					x += dr[d];
					y += dc[d];	
				}
			}
			System.out.println("#" + tc);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
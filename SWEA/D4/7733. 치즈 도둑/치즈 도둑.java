import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int N;
	static int[][] cheese;
	static boolean[][] eat;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			cheese = new int[N][N];

			int max = Integer.MIN_VALUE;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					cheese[i][j] = sc.nextInt();
				}
			}
			
			for(int x = 0; x <= 100; x++) {
				int pieces = 0;
				eat = new boolean[N][N];
				eatCheese(cheese, x);
				
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(!eat[i][j] && cheese[i][j] != 0) {
							pieces++;
							countPieces(i, j);
						}
					}
				}
				if(max < pieces) max = pieces;
			}
			
			System.out.printf("#%d %d\n", tc, max);
		}
	}
	
	static void eatCheese(int[][] cheese, int x) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(cheese[i][j] == x) {
					cheese[i][j] = 0;
					eat[i][j] = true;
				}
			}
		}	
	}
	static void countPieces(int X, int Y) {
		int cr = X;
		int cc = Y;

		eat[cr][cc] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = cr + dr[d];
			int nc = cc + dc[d];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && !eat[nr][nc] && cheese[nr][nc] != 0) {
				countPieces(nr, nc);
			}
		}
	}
}
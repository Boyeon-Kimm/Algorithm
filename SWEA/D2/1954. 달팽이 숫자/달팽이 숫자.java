import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] nr = {0, 1, 0, -1};
		int[] nc = {1, 0, -1, 0};
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			int cr = 0, cc = 0, d = 0; 
			
			for(int i = 1; i <= N * N; i++) {
				snail[cr][cc] = i; 
				int x = cr + nr[d];
				int y = cc + nc[d];
				
				if(x < 0 || x >= N || y < 0 || y >= N || snail[x][y] != 0) {
					d = (d + 1) % 4;
				}
				cr += nr[d];
				cc += nc[d];
			}
			
			System.out.println("#" + tc);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.printf("%d ", snail[i][j]);
				}
				System.out.println();
			}
		}
	}
}
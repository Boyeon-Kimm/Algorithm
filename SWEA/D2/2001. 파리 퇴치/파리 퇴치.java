import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
		
			int[][] flies = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					flies[i][j] = sc.nextInt();
				}
			}
			int max = Integer.MIN_VALUE;
			for(int i = 0; i <= N - M; i++) {
				for(int j = 0; j <= N - M; j++) {
					int kill = 0;
					for(int k = i; k < i + M; k++) {
						for(int l = j; l < j + M; l++) {
							kill += flies[k][l];
						}
					}
					max = Math.max(max, kill);
				}
			}
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
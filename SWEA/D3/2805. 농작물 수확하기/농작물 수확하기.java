import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					farm[i][j] = str.charAt(j) -'0';
				}
			}
			int sum = 0;
			for(int i = 0; i < N / 2; i++) {
				for(int j = N / 2 - i; j <= N / 2 + i; j++) {
					sum += farm[i][j];
				}
			}
			for(int i = N / 2; i < N; i++) {
				for(int j = i - N / 2; j <= N / 2 * 3 - i; j++) {
					sum += farm[i][j];
				}
			}
			System.out.printf("#%d %d\n", tc, sum);
		}
	}
}
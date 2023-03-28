import java.util.Scanner;

public class Solution {
	static int N, min;
	static boolean[] visited;
	static int[][] ingre;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			ingre = new int[N][N];
            
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					ingre[i][j] = sc.nextInt();
				}
			}

			min = Integer.MAX_VALUE;
			visited = new boolean[N];
			
			perm(0, 0);

			System.out.printf("#%d %d\n", tc, min);
		}
	}
	private static void perm(int idx, int s) {
		if(idx == N / 2) {
			int sum1 = 0, sum2 = 0;
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					if(visited[i] && visited[j]) {
						sum1 += ingre[i][j] + ingre[j][i];
					} else if(!visited[i] && !visited[j]) {
						sum2 += ingre[i][j] + ingre[j][i];
					}
				}
			}
			int gap = Math.abs(sum1 - sum2);
			min = Math.min(min, gap);
			return;
		}

		for(int i = s; i < N; i++) {
			visited[i] = true;
			perm(idx + 1, i + 1);
			visited[i] = false;
		}
	}
}

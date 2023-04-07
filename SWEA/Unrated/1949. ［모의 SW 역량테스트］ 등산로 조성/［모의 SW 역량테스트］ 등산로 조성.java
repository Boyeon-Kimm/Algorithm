import java.util.Scanner;

public class Solution {
	static int N, K, ans;
	static int[][] mountain;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			mountain = new int[N][N];
			visited = new boolean[N][N];
			
			ans = 0;
			int maxH = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					mountain[i][j] = sc.nextInt();
					maxH = Math.max(maxH, mountain[i][j]);
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(mountain[i][j] == maxH) 
						work(i, j, 1, true);
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	private static void work(int x, int y, int dist, boolean skill) {
		if(dist > ans) ans = dist;
		visited[x][y] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = dr[d] + x;
			int nc = dc[d] + y;
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
			
			if(mountain[x][y] > mountain[nr][nc])
				work(nr, nc, dist + 1, skill);
			
			else if(skill && mountain[x][y] > mountain[nr][nc] - K) {
				int tmp = mountain[nr][nc];
				mountain[nr][nc] = mountain[x][y] - 1;
				work(nr, nc, dist + 1, false);
				mountain[nr][nc] = tmp;
			}
		}
		visited[x][y] = false;
	}
}
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int[] dr2 = {-1, -1, 1, 1};
		int[] dc2 = {-1, 1, -1, 1};
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] fly = new int[N][N];
			int M = sc.nextInt(); // 분사되는 범위
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					fly[i][j] = sc.nextInt();
				}
			}
			int max = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int kill = 0;
					kill += fly[i][j];
					for(int range = 1; range < M; range++) {
						for(int d = 0; d < 4; d++) {
							int nr = dr[d] * range + i;
							int nc = dc[d] * range + j;
							if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
							kill += fly[nr][nc];
						}
						if(max < kill) max = kill;
					}
				}
			}
			int max2 = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int kill = 0;
					kill += fly[i][j];
					for(int range = 1; range < M; range++) {
						for(int d = 0; d < 4; d++) {
							int nr = dr2[d] * range + i;
							int nc = dc2[d] * range + j;
							if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
							kill += fly[nr][nc];
						}
						if(max2 < kill) max2 = kill;
					}
				}
			}
			System.out.print("#" + tc + " ");
			if(max < max2) System.out.println(max2);
			else System.out.println(max);
		}
	}
}
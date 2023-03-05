import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
		int[] dc = {0, 0, -1, 1, 1, -1, -1, 1};

		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[][] omok = new char[N][];
			for(int i = 0; i < N; i++) {
				omok[i] = sc.next().toCharArray();
			}
			String answer = "NO";
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(omok[i][j] == 'o') {
						for(int d = 0; d < 8; d++) {
							int cnt = 0;
							for(int range = 1; range <= 4; range++) {
								int nr = dr[d] * range + i;
								int nc = dc[d] * range + j;
								if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
								if(omok[nr][nc] == 'o') cnt++;
								if(cnt >= 4) {
									answer = "YES";
									break;
								}
							} 
						}
					} else continue;
				}
			}
			System.out.printf("#%d %s\n", tc, answer);
		}
	}
}
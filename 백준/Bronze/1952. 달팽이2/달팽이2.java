import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] snail = new int[m][n];
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		int d = 0;
		int cr = 0;
		int cc = 0;
		int cnt = 0;
	
		for(int t = 1; t <= m * n; t++) {
			snail[cr][cc] = 1;
			int nr = dr[d] + cr;
			int nc = dc[d] + cc;
			if(nr < 0 || nr >= m || nc < 0 || nc >= n || snail[nr][nc] != 0) {
				d = (d + 1) % 4;
				cnt++;
			}
			cr += dr[d];
			cc += dc[d];
		}
		System.out.println(cnt - 1);
	}
}

import java.util.Scanner;

public class Solution {
	static int N, cnt;
	static boolean[] visited;
	static boolean[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			int M = sc.nextInt();
			
			visited = new boolean[N + 1];
			arr = new boolean[N + 1][N + 1];
			
			for(int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr[a][b] = true;
				arr[b][a] = true;
			}
			cnt = 0;
			for(int i = 1; i <= N; i++) {
				boolean flag = false;
				for(int j = 1; j <= N; j++) {
					if(arr[i][j]) {
						flag = true;
					}
					if(arr[i][j] && !visited[j]) {
						DFS(j);
						cnt++;
					}
				}
				if(!flag) cnt++;
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
	private static void DFS(int x) {
		visited[x] = true;
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && arr[x][i]) {
				DFS(i);
			}
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] tomato;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		tomato = new int[N][M];
		
		int x = 0, y = 0;
		int num = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j] != 0) num++;
				if(tomato[i][j] == 1) {
					q.add(new int[] {i, j});
				}
			}
		}
		if(num == N * M) {
			System.out.println(0);
			return;
		}

		bfs(x, y);
		int cnt = 0, ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tomato[i][j] == 0) cnt++;
				ans = Math.max(ans, tomato[i][j]);
			}
		}
		if(cnt > 0) System.out.println(-1);
		else System.out.println(ans - 1);
	}
	private static void bfs(int x, int y) {

		while(!q.isEmpty()) {
			int[] node = q.poll();
			int currX = node[0];
			int currY = node[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = dr[d] + currX;
				int nc = dc[d] + currY;
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || tomato[nr][nc] != 0) continue;
				
				tomato[nr][nc] = tomato[currX][currY] + 1;
				q.add(new int[] {nr, nc});
			}
		}
	}
}
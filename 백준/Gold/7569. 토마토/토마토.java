import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H, N, M;
	static int[][][] tomato;
	static Queue<int[]> q;
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomato = new int[H][N][M];
		q = new LinkedList<>();
		
		int cnt = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < M; k++) {
					tomato[i][j][k] = Integer.parseInt(st.nextToken());
					if(tomato[i][j][k] == 1) q.add(new int[] {i, j, k});
					if(tomato[i][j][k] != 0) cnt++;
				}
			}
		}
		if(cnt == H * N * M) {
			System.out.println(0);
			return;
		}
		bfs(0, 0, 0);
		int ans = Integer.MIN_VALUE;
		loop : for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					ans = Math.max(ans, tomato[i][j][k]);
					if(tomato[i][j][k] == 0) {
						ans = 0;
						break loop;
					}
				}
			}
		}
		System.out.println(ans - 1);
	}
	private static void bfs(int h, int x, int y) {
		while(!q.isEmpty()) {
			int[] node = q.remove();
			int currH = node[0];
			int currX = node[1];
			int currY = node[2];
			
			for(int d = 0; d < 6; d++) {
				int nh = dh[d] + currH;
				int nr = dr[d] + currX;
				int nc = dc[d] + currY;
				
				if(nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M || tomato[nh][nr][nc] != 0) continue;
				
				tomato[nh][nr][nc] = tomato[currH][currX][currY] + 1;
				q.add(new int[] {nh, nr, nc});
			}
		}
	}
}
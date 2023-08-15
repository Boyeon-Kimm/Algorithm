import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int clean;
	static int[][] room;
	static int[] dr = {-1, 0, 1, 0}; // 북동남서
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		room = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		clean = 1;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(x, y, d);
		System.out.println(clean);
	}

	private static void dfs(int x, int y, int d) {
		room[x][y] = 2; // 현재 위치 청소

		for(int i = 0; i < 4; i++) {
			d = (d + 3) % 4; // 반시계 방향으로 전환(북 서 남 동)
			int nr = dr[d] + x;
			int nc = dc[d] + y;
			
			if(nr >= 0 && nc >= 0 && nr < N && nc < M && room[nr][nc] == 0) {
				clean++;
				dfs(nr, nc, d);
				return;
			}
		}
		// 네 방향 모두 청소되어있거나 벽인 경우
		// 뒤쪽 칸이 벽이 아니라는 전제 하에 바라보는 방향 유지한 채로 한 칸 후진
		int back = (d + 2) % 4;
		int br = dr[back] + x;
		int bc = dc[back] + y;
		
		if(br >= 0 && br < N && bc >= 0 && bc < M && room[br][bc] != 1) {
			dfs(br, bc, d);
		}
	}
}
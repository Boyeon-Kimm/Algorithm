import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static char[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int M;
	static int N;
	static String ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		visited = new boolean[M][N];
		map = new char[M][N];
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		ans = "NO";
		for(int i = 0; i < 1; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == '0' && !visited[i][j]) {
					dfs(i, j);
				}
			}
		}
		System.out.println(ans);
	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = dr[d] + x;
			int nc = dc[d] + y;
			
			if(nr >= M || nc >= N || nr < 0 || nc < 0 || visited[nr][nc]) continue;
			
			if(map[nr][nc] == '0') {
				visited[nr][nc] = true;
				dfs(nr, nc);
			}
		}
		if(x == M - 1) {
			ans = "YES";
			return;
		}
	}
}
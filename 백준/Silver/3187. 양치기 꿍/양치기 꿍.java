import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static char[][] farm;
	static int R;
	static int C;
	static int sheep;
	static int wolf;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		visited = new boolean[R][C];
		farm = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j = 0; j < C; j++) {
				farm[i][j] = str.charAt(j);
			}
		}
		
		int totalS = 0;
		int totalW = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if((farm[i][j] == 'v' || farm[i][j] == 'k') && !visited[i][j]) {
					if(farm[i][j] == 'k') {
						sheep = 1;
						wolf = 0;
					} else {
						sheep = 0;
						wolf = 1;
					}
					dfs(i, j);
					if(sheep > wolf) totalS += sheep;
					else totalW += wolf;
				}
			}
		}
		System.out.println(totalS + " " + totalW);
	}
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = dr[d] + x;
			int nc = dc[d] + y;
			
			if(nr >= R || nr < 0 || nc >= C || nc < 0 || visited[nr][nc] || farm[nr][nc] == '#') continue;
			
			if(farm[nr][nc] == 'v') wolf++;
			else if(farm[nr][nc] == 'k') sheep++;
			
			visited[nr][nc] = true;
			dfs(nr, nc);
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static char[][] farm;
	static int R;
	static int C;
	static int wolf;
	static int sheep;
	
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
		
		int totalW = 0;
		int totalS = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if((farm[i][j] == 'o' || farm[i][j] == 'v') && !visited[i][j]) {
					wolf = 0;
					sheep = 0;
					dfs(i, j);
					if(wolf >= sheep) totalW += wolf;
					else totalS += sheep;
				}
			}
		}
		System.out.println(totalS + " " + totalW);
	}
	
	private static void dfs(int x, int y) {
		int[] dr = {-1, 1, 0 ,0};
		int[] dc = {0, 0, -1, 1};
		
		visited[x][y] = true;
		if(farm[x][y] == 'v') wolf++;
		else if(farm[x][y] == 'o') sheep++;
		
		for(int d = 0; d < 4; d++) {
			int nr = dr[d] + x;
			int nc = dc[d] + y;
				
			if(nr >= R || nc >= C || nr < 0 || nc < 0 || visited[nr][nc] || farm[nr][nc] == '#') continue;
			
			visited[nr][nc] = true;
			dfs(nr, nc);
		}
	}
}
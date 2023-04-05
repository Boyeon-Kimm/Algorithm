import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static char[][] art;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		art = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				art[i][j] = str.charAt(j);
			}
		}
		visited = new boolean[N][N];
		int p1 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i, j);
					p1++;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
		int p2 = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(art[i][j] == 'G') art[i][j] = 'R';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i, j);
					p2++;
				}
			}
		}
		System.out.println(p1 + " " + p2);
	}
	private static void bfs(int x, int y) {
		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] node = q.remove();
			int currX = node[0];
			int currY = node[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = dr[d] + currX;
				int nc = dc[d] + currY;

				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || art[x][y] != art[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
	}
}
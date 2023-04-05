import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, trash;
	static boolean[][] map, visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			map[a][b] = true;
		}
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j]) {
					trash = 1;
					dfs(i, j);
					list.add(trash);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < list.size(); i++) {
			max = Math.max(max, list.get(i));
		}
		System.out.println(max);
	}
	
	private static void dfs(int x, int y) {
		visited[x][y] = true;

		for(int d = 0; d < 4; d++) {
			int nr = dr[d] + x;
			int nc = dc[d] + y;
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || !map[nr][nc]) continue;
			
			visited[nr][nc] = true;
			trash++;
			dfs(nr, nc);
		}
	}
}
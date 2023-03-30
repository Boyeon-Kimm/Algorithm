import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] maze;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && maze[i][j] == 1) {
					visited[i][j] = true;
					bfs(i, j);
				}
			}
		}
	}
	private static void bfs(int x, int y) {
		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int curX = arr[0];
			int curY = arr[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = dr[d] + curX;
				int nc = dc[d] + curY;
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
				
				if(maze[nr][nc] == 1) {
					visited[nr][nc] = true;
					maze[nr][nc] = maze[curX][curY] + 1;
					q.add(new int[] {nr, nc});
				}
				
				if(nr == N - 1 && nc == M - 1) {
					System.out.println(maze[nr][nc]);
					break;
				}
			}
		}
		
	}
}
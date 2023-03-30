import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[][] visited;
	static int[][] board;
	static int[] from, to;
	static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st;
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			visited = new boolean[N][N];
			
			from = new int[2];
			to = new int[2];
			
			st = new StringTokenizer(br.readLine());
			from[0] = Integer.parseInt(st.nextToken());
			from[1] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			to[0] = Integer.parseInt(st.nextToken());
			to[1] = Integer.parseInt(st.nextToken());
		
			if(Arrays.equals(from, to))
				System.out.println(0);
			bfs(from[0], from[1]);
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
			
			for(int d = 0; d < 8; d++) {
				int nr = dr[d] + curX;
				int nc = dc[d] + curY;
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
				
				board[nr][nc] = board[curX][curY] + 1;
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
				
				if(nr == to[0] && nc == to[1]) {
					System.out.println(board[nr][nc]);
					return;
				}
			}
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static int[][] war;
	static int N;
	static int M;
	static int cntW;
	static int cntB;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		visited = new boolean[M][N];
		war = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				war[i][j] = str.charAt(j);
			}
		}
		
		cntW = 1;
		cntB = 1;
		int white = 0;
		int black = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(war[i][j] == 'W' && !visited[i][j]) {
					bfsW(i, j);
					white += cntW * cntW;
					cntW = 1;
				} else if(war[i][j] == 'B' && !visited[i][j]) {
					bfsB(i, j);
					black += cntB * cntB;
					cntB = 1;
				}
			}
		}
		System.out.println(white + " " + black);
	}

	private static void bfsB(int x, int y) {
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
				
				if(nr >= M || nc >= N || nr < 0 || nc < 0 || visited[nr][nc]) continue;
				
				if(!visited[nr][nc] && war[nr][nc] == 'B') {
					cntB++;
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
		}
	}

	private static void bfsW(int x, int y) {
		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int cr = node[0];
			int cc = node[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = dr[d] + cr;
				int nc = dc[d] + cc;
				
				if(nr >= M || nc >= N || nr < 0 || nc < 0 || visited[nr][nc]) continue;
				
				if(war[nr][nc] == 'W' && !visited[nr][nc]) {
					cntW++;
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
		}
	}
}
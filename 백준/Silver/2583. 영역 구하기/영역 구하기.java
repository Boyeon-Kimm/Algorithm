import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int area, N, M;
	static boolean[][] visited, adj;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		visited = new boolean[M][N];
		adj = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int leftX = Integer.parseInt(st.nextToken());
			int leftY = Integer.parseInt(st.nextToken());
			int rightX = Integer.parseInt(st.nextToken()) - 1;
			int rightY = Integer.parseInt(st.nextToken()) - 1;

			for (int k = leftY; k <= rightY; k++) {
				for (int j = leftX; j <= rightX; j++) {
					adj[k][j] = true;
				}
			}
		}

		int cnt = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && !adj[i][j]) {
					area = 1;
					bfs(i, j);
					list.add(area);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(list);
		for(int l : list) {
			System.out.print(l + " ");
		}
	}

	private static void bfs(int x, int y) {
		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int currX = curr[0];
			int currY = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = dr[d] + currX;
				int nc = dc[d] + currY;
				
				if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
				if (!visited[nr][nc] && !adj[nr][nc]) {
					visited[nr][nc] = true;
					area++;
					q.add(new int[] { nr, nc });
				}
			}
		}
	}
}
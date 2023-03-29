import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int N, cnt = 0;
	static boolean[][] adj;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		adj = new boolean[N + 1][N + 1];
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
		
			adj[x][y] = true;
			adj[y][x] = true;
		}
		visited = new boolean[N + 1];
		
		dfs(1);
		System.out.println(cnt - 1);
	}
	static void dfs(int v) {
		visited[v] = true;
		cnt++;
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && adj[v][i]) {
				dfs(i);
			}
		}
	}
}
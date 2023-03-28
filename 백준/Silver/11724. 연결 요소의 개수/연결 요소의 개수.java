import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[][] adj;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adj = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = true;
			adj[b][a] = true;
		}
		
		int cnt = 0;
		for(int i = 1; i < N + 1; i++) {
			if(!visited[i]) {
				DFS(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	private static void DFS(int v) {
		visited[v] = true;

		for(int i = 1; i < N + 1; i++) {
			if(!visited[i] && adj[v][i]) DFS(i);
		}
	}
}

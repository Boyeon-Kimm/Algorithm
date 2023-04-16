import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] result;
	static boolean[] visited;
	static List<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());

		adj = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		result = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adj[to].add(from);
			adj[from].add(to);
		}

		for(int i = 1; i <= N; i++) {
			if(!visited[i]) dfs(i);
		}

		for(int i = 2; i <= N; i++) {
			System.out.println(result[i]);
		}
	}

	private static void dfs(int v) {
		visited[v] = true;
		
		for(int n : adj[v]) {
			if(!visited[n]) {
				result[n] = v;
				dfs(n);
			}
		}
	}
}
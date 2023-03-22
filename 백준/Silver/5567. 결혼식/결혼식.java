import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		List<Integer> list[] = new ArrayList[n + 1];
		
		for(int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		visited = new boolean[n + 1];
		visited[1] = true;
		dfs(1, list, 0);
		int result = 0;
		for(int i = 2; i < visited.length; i++) {
			if(visited[i]) result++;
		}
		System.out.println(result);
	}

	private static void dfs(int n, List<Integer>[] list, int depth) {
		if(depth == 2) return;
		
		for(int i = 0; i < list[n].size(); i++) {
			int next = list[n].get(i);
			visited[next] = true;
			dfs(next, list, depth + 1);
		}
		
	}
}

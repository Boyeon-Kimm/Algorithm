import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, p1, p2;
	static int cnt = 0;
	static Stack<Integer> stack = new Stack<>();
	static boolean[][] fam;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		fam = new boolean[N + 1][N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
		
			fam[x][y] = true;
			fam[y][x] = true;
		}
		cnt = -1;
		visited = new boolean[N + 1];
		DFS(p1, 0);
		System.out.println(cnt);
	}

	private static void DFS(int p1, int x) {
		visited[p1] = true;
		
		if(p1 == p2) {
			cnt = x;
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(fam[p1][i] && !visited[i]) DFS(i, x + 1);
		}
	}
}
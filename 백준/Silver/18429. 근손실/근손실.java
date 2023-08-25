import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int cnt;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	
		arr = new int[N];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		cnt = 0;
		backtracking(500, 0);
		System.out.println(cnt);
	}

	private static void backtracking(int w, int x) {
		if(x == N) {
			cnt++;
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i] && w - K + arr[i] >= 500) {
				visited[i] = true;
				backtracking(w - K + arr[i], x + 1);
				visited[i] = false;
			}
		}
	}
}
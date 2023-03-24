import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] arr, res;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		res = new int[N];
		sb = new StringBuilder();
		
		int j = 0;
		for(int i = 1; i <= N; i++) {
			arr[j++] = i;
		}
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int idx) {
		if(idx == N) {
			for(int i = 0 ; i < N; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			res[idx] = arr[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
		
	}
}

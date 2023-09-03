import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int result;
	static int[] arr;
	static int[] ans;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		ans = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		backtracking(0);
		System.out.println(result);
	}
	private static void backtracking(int num) {
		if(num == N) {
			int sum = 0;
			for(int i = 0; i < N - 1; i++) {
				sum += Math.abs(ans[i] - ans[i + 1]);
			}
			result = Math.max(result, sum);
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				ans[num] = arr[i];
				visited[i] = true;
				backtracking(num + 1);
				visited[i] = false;
			}
		}
	}
}
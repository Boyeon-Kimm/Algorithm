import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, min;
	static boolean[] visited;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		visited = new boolean[N];
		perm(0, 0);
		
		System.out.println(min);
	}
	
	static void perm(int idx, int s) {
		if(idx == N / 2) {
			int sum1 = 0, sum2 = 0;
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					if(!visited[j] && !visited[i]) {
						sum1 += arr[i][j] + arr[j][i];
					} else if(visited[i] && visited[j]) {
						sum2 += arr[i][j] + arr[j][i];
					}
				}
			}
			int gap = Math.abs(sum1 - sum2);
			min = Math.min(gap, min);
			return;
		}
		for(int i = s; i < N; i++) {
			visited[i] = true;
			perm(idx + 1, i + 1);
			visited[i] = false;
		}
	}
}
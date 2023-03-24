import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] num, res;
	static boolean[] visit;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		res = new int[N];		
		visit = new boolean[N];
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		perm(0, 0);
		System.out.println(sb);
	}
	private static void perm(int idx, int s) {
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = s; i < N; i++) {
			if(visit[i]) continue;
			res[idx] = num[i];
			visit[i] = true;
			perm(idx + 1, i);
			visit[i] = false;
		}	
	}
}

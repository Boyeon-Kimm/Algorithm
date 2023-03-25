import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static int[] S, res;
	static boolean[] visit;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		while(flag) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) flag = false;
			res = new int[k];
			S = new int[k];
			visit = new boolean[k];
			sb = new StringBuilder();
		
			for(int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			perm(0, 0);
			System.out.println(sb);
		}
		
	}
	private static void perm(int idx, int s) {
		if(idx == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = s; i < k; i++) {
			if(visit[i]) continue;
			res[idx] = S[i];
			visit[i] = true;
			perm(idx + 1, i);
			visit[i] = false;
		}
	}
}

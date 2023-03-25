import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[] ch, res;
	static boolean[] visit;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			String str = br.readLine();
			ch = str.toCharArray();
			N = ch.length;
			res = new char[N];
			visit = new boolean[N];
			
			System.out.println("Case # " + tc + ":");
			combination(0);
			System.out.print(sb);
		}
	}

	private static void combination(int idx) {
		if(idx == N) {
			for(int i = 0; i < N; i++) {
				sb.append(res[i]);
			}
			sb.append("\n");
			return;
		}
		for(int i = 0; i < N; i++) {
			if(visit[i]) continue;
			res[idx] = ch[i];
			visit[i] = true;
			combination(idx + 1);
			visit[i] = false;
		}
		
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static String[] str, res;
	static boolean[] visit;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		str = new String[C];
		res = new String[C];
		visit = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			str[i] = st.nextToken();
		}
		Arrays.sort(str);
		combination(0, 0);
	}

	private static void combination(int idx, int s) {
		if(idx == L){
			int v = 0;
			int c = 0;
			sb = new StringBuilder();
			for(int i = 0; i < L; i++) {
				sb.append(res[i]);
				if(res[i].equals("a") || res[i].equals("e") || res[i].equals("i") || res[i].equals("o") || res[i].equals("u")) {
					v++;
				} else c++;
			}
			if(v >= 1 && c >= 2) System.out.println(sb);
		}
		for(int i = s; i < C; i++) {
			if(visit[i]) continue;
			res[idx] = str[i];
			visit[i] = true;
			combination(idx + 1, i);
			visit[i] = false;
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수

		p = new int[N + 1];
		for(int i = 0; i <= N; i++) {
			p[i] = i;
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			switch(n) {
				case 0 :
					union(findset(a), findset(b));
					break;
					
				case 1 :
					if(findset(a) != findset(b)) {
						sb.append("NO").append("\n");
					} else sb.append("YES").append("\n");
					break;
			}
		}
		System.out.println(sb);
	}
	private static int findset(int x) {
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
	
	private static void union(int i, int j) {
		p[j] = i;
	}
}
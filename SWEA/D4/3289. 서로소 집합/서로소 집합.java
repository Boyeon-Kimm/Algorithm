import java.util.Scanner;

public class Solution {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			p = new int[N + 1];
			for(int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				int c = sc.nextInt();

				switch(c) {
					case 0 :
						union(sc.nextInt(), sc.nextInt());
						break;
						
					case 1 :
						int a = findset(sc.nextInt());
						int b = findset(sc.nextInt());
						
						if(a == b) sb.append(1);
						else sb.append(0);
						break;
				}
			}
			System.out.println("#"+ tc + " " + sb);
		}
	}
	static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}
	
	private static int findset(int x) {
		if(p[x] != x) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}
}
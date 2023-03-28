import java.util.Scanner;

public class Solution {
	static int N, min;
	static int[] res;
	static boolean[] visited;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N + 2][2];
			res = new int[N + 2];
			visited = new boolean[N + 2];

			min = Integer.MAX_VALUE;

			for(int i = 0; i < N + 2; i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			
			res[0] = 0; 
			res[N + 1] = 1;
			
			perm(1);
			
			System.out.printf("#%d %d\n", tc, min);
		}
	}

	private static void perm(int idx) {
		if(idx == N + 1) {
			int sum = 0;
			for(int i = 0; i < N + 1; i++) {
				sum += Math.abs(map[res[i]][0] - map[res[i + 1]][0]) + Math.abs(map[res[i]][1] - map[res[i + 1]][1]);
			}
			if(min > sum) min = sum;
			return;
		}

		for(int i = 2 ; i < N + 2; i++) {
			if(visited[i]) continue;
			res[idx] = i;
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}
}

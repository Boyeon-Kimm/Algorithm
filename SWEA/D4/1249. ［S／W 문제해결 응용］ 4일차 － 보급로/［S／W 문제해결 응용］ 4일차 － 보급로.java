import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[][] map, fix;
	static int N, time;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static class Node {
		int x, y, t;

		Node(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			fix = new int[N][N];
			fix[0][0] = 1;

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			bfs(0, 0);
			System.out.printf("#%d %d\n", tc, time-1);
		}
	}

	private static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y, 0));
		time = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			Node node = q.remove();
			int currX = node.x;
			int currY = node.y;
			int currT = node.t;

			if (currX == N - 1 && currY == N - 1) {
				time = Math.min(time, currT);
			}

			for (int d = 0; d < 4; d++) {
				int nr = dr[d] + currX;
				int nc = dc[d] + currY;

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;

				if (fix[nr][nc] == 0 || fix[currX][currY] + map[nr][nc] < fix[nr][nc]) {
					fix[nr][nc] = map[nr][nc] + fix[currX][currY];
					q.offer(new Node(nr, nc, fix[nr][nc]));
				}
			}
		}
	}
}
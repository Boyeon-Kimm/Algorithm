import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int end, w;

		Node(int end, int w) {
			this.end = end;
			this.w = w;
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int N, D;
	static int[] dist;
	static List<Node>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		dist = new int[D + 1];
		list = new ArrayList[D + 1];

		for (int i = 0; i < list.length; i++) {
			dist[i] = INF;
			list[i] = new ArrayList<>();
			if (i != D)
				list[i].add(new Node(i + 1, 1));
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			if (to > D) continue;
			if (to - from > w) {
				list[from].add(new Node(to, w));
			}
		}
		dijkstra(0);
		System.out.println(dist[D]);
	}

	private static void dijkstra(int start) {
		if (start > D)
			return;

		dist[start] = 0;

		for (int i = 0; i <= D; i++) {
			for (Node n : list[i]) {
				if (dist[n.end] <= dist[i] + n.w) continue;
				dist[n.end] = dist[i] + n.w;
			}
		}
	}
}
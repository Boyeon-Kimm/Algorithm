import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine());
		int[] card = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		int[] result = new int[20000001];
		while (!q.isEmpty()) {
			int find = q.poll();
			result[find + 10000000]++;
		}
		for (int i = 0; i < M; i++) {
			sb.append(result[card[i] + 10000000]).append(" ");
		}
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] in_degree, res;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		in_degree = new int[N + 1];
		res = new int[N + 1];
		list = new ArrayList[N + 1];
		
		Arrays.fill(res, 1);
		
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			in_degree[to]++;
		}
		
		TopologicalSort();
		for(int i = 1; i <= N; i++) {
			System.out.print(res[i] + " ");
		}
	}
	private static void TopologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(in_degree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int v = q.remove();
			for(int i = 0; i < list[v].size(); i++) {
				int n = list[v].get(i);
				in_degree[n]--;
				res[n] = res[v] + 1;
				if(in_degree[n] == 0) q.add(n);
			}
		}
	}
}
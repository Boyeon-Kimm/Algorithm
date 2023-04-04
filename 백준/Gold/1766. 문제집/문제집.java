import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] adjList = new ArrayList[N + 1];
		int[] in_degree = new int[N + 1];
		
		for(int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
			
			in_degree[to]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 1; i <= N; i++) {
			if(in_degree[i] == 0) pq.add(i);
		}
		
		while(!pq.isEmpty()) {
			int n = pq.remove();
			sb.append(n).append(" ");
			for(int i = 0; i < adjList[n].size(); i++) {
				int num = adjList[n].get(i);
				in_degree[num]--;
				if(in_degree[num] == 0) pq.add(num);
			}
		}
		System.out.println(sb);
	}
}
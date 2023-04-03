import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static int[][] adj;
	static List<Integer>[] adjList;
	static int[] in_degree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			int V = sc.nextInt(); // 정점의 개수
			int E = sc.nextInt(); // 간선의 개수
			
			adjList = new ArrayList[V + 1];
			for(int i = 0; i <= V; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			in_degree = new int[V + 1];
			for(int i = 0; i < E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				adjList[from].add(to);
				adjList[to].add(from);
				
				in_degree[to]++;
			}
			
			Queue<Integer> q = new LinkedList<>();
			
			for (int i = 1; i <= V; i++) {
				if (in_degree[i] == 0) q.add(i);
			}
			
			while(!q.isEmpty()) {
				int n = q.remove();
//				System.out.println(n);
				sb.append(n).append(" ");
				for(int i = 0; i < adjList[n].size(); i++) {
					int v = adjList[n].get(i);
					in_degree[v]--;
					if(in_degree[v] == 0) {
						q.add(v);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			// 섬의 좌표를 입력받을 배열
			int[][] island = new int[N][2];
						
			// 행 좌표
			for(int i = 0; i < N; i++) {
				island[i][0] = sc.nextInt();
			}
			// 열 좌표
			for(int i = 0; i < N; i++) {
				island[i][1] = sc.nextInt();
			}
			// 세율 입력
			double E = sc.nextDouble();
			
			List<Edge>[] adjList = new ArrayList[N];
		
			for(int i = 0; i < N; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < N - 1; i++) {
				for(int j = 1; j < N; j++) {
					long r = Math.abs(island[i][0] - island[j][0]);
					long c = Math.abs(island[i][1] - island[j][1]);
				
					adjList[i].add(new Edge(i, j, r * r + c * c));
					adjList[j].add(new Edge(j, i, r * r + c * c));
				}
			}
			
			boolean[] visited = new boolean[N];
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			visited[0] = true;
			
			pq.addAll(adjList[0]);
			
			int pick = 0;
			long cost = 0;
			
			while(pick < N - 1) {
				Edge e = pq.poll();
				if(visited[e.end]) continue;
				
				cost += e.d;
				visited[e.end] = true;
				pick++;
				
				pq.addAll(adjList[e.end]);
			}
			long res = Math.round(E * cost);
			System.out.printf("#%d %d\n", tc, res);
		}
	}
	
	public static class Edge implements Comparable<Edge>{
		int start, end;
		long d;
		
		Edge(int start, int end, long d){
			this.start = start;
			this.end = end;
			this.d = d;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.d, o.d);
		}
		
	}
}
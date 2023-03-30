import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int[] p;
	static int[][] island;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			island = new int[N][2];
			
			for(int i = 0; i < N; i++) {
				island[i][0] = sc.nextInt();
			}
			
			for(int i = 0; i < N; i++) {
				island[i][1] = sc.nextInt();
			}
			
			double E = sc.nextDouble();
			
			// makeset
			p = new int[N];
			for(int i = 0; i < N; i++) {
				p[i] = i;
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			for(int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {
					long dr = Math.abs(island[i][0] - island[j][0]);
					long dc = Math.abs(island[i][1] - island[j][1]);
					
					pq.offer(new Edge(i, j, (dr * dr + dc * dc)));
				}
			}
			
			int pick = 0;
			double cost = 0;
			while(pick < N - 1) {
				Edge edge = pq.poll();
				int x = edge.x;
				int y = edge.y;
				
				if(!union(x, y)) continue;
				
				cost += edge.d;
				pick++;
			}
			System.out.println("#" + tc + " " + Math.round(cost * E));
		}
	}
	
	private static boolean union(int x, int y) {
		if(findset(x) == findset(y)) 
		return false;
		
		p[findset(y)] = findset(x);
		return true;
		
	}
	
	private static int findset(int x) {
		if(p[x] != x)
			p[x] = findset(p[x]);
		return p[x];
	}
	public static class Edge implements Comparable<Edge>{
		int x, y;
		long d;
		
		Edge(int x, int y, long d){
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Edge o) {
			return this.d < o.d ? -1 : 1;
		}
		
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		int x, cnt;
		
		Node(int x, int cnt){
			this.x = x;
			this.cnt = cnt;
		}
	}
	static int N, K;
	static int[] hide;
	static boolean[] visited;
	static int[] dr = {-1, 1, 2};
	static Queue<Node> q;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		q = new LinkedList<>();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if (N == K) {
			System.out.println(0);
			return;
		}
		hide = new int[100001];
		visited = new boolean[100001];
		bfs(N);
	}
	public static void bfs(int idx) {
		q.add(new Node(idx, 0));
		visited[idx] = true;
		
		loop : while(!q.isEmpty()) {
			Node node = q.poll();
			int cr = node.x;
			int cCnt = node.cnt;
			
			for(int d = 0; d < 3; d++) {
				int nr = 0;
				if(d == 2) nr = cr * 2;
				else nr = dr[d] + cr;
				if(nr < 0 || nr > 100000 || visited[nr]) continue;
				visited[nr] = true;
				if(nr == K) {
					System.out.println(cCnt + 1);
					break loop;
				}
//				System.out.println(cCnt);
				q.add(new Node(nr, cCnt+1));
			}
		}
	}

}
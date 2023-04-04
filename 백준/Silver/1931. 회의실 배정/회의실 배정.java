import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node>{
		int start, end;
		
		Node(int start, int end){
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Node o) {
			return end == o.end ? start - o.start : end - o.end;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node nodes[] = new Node[N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			nodes[i] = new Node(start, end);
		}
		
		Arrays.sort(nodes);
		
		int cnt = 0, preEnd = 0;
		for(int i = 0; i < N; i++) {
			Node curr = nodes[i];
			if(preEnd <= curr.start) {
				preEnd = curr.end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
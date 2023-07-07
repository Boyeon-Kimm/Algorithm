import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<int[]> queue = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				queue.add(new int[] {i, num});
			}
			
			int cnt = 0;
			while(true) {
				int[] cur = queue.poll();
				boolean check = true;
				
				for(int[] curQ : queue) {
					if(curQ[1] > cur[1]) {
						check = false;
						break;
					}
				}
				if(check) {
					cnt++;
					if(cur[0] == M) break;
				} else {
					queue.add(cur);
				}
			}
			System.out.println(cnt);
		}
	}
}

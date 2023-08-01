import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		LinkedList<Integer> dq = new LinkedList<>();
		for(int i = 1; i <= N; i++) dq.add(i);
		
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		while(M-- > 0) {
			int num = Integer.parseInt(st.nextToken());
			int idx = dq.indexOf(num);
			int size = dq.size();
			
			if(idx == -1) continue;
			
			if(size / 2 >= idx) {
				while(num != dq.peekFirst()) {
					dq.addLast(dq.removeFirst());
					cnt++;
				}
				dq.removeFirst();
			} else {
				while(num != dq.peekFirst()) {
					dq.addFirst(dq.removeLast());
					cnt++;
				}
				dq.removeFirst();
			}
		}
		System.out.println(cnt);
	}
}
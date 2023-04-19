import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num > 0) {
				pq.add(num);
			} else if (num == 0) {
				if(!pq.isEmpty() && !pq2.isEmpty()) {
					int a = pq.peek();
					int b = Math.abs(pq2.peek());

					if (a > b) {
						sb.append(pq2.remove()).append("\n");
					} else if (a == b) {
						sb.append(pq2.remove()).append("\n");
					} else {
						sb.append(pq.remove()).append("\n");
					}
				} else if(pq.isEmpty() && !pq2.isEmpty()) {
					sb.append(pq2.remove()).append("\n");
				} else if(!pq.isEmpty() && pq2.isEmpty()){
					sb.append(pq.remove()).append("\n");
				} else if(pq.isEmpty() && pq2.isEmpty()) {
					sb.append(0).append("\n");
				}
			} else {
				pq2.add(num);
			}
		}
		System.out.println(sb);
	}
}
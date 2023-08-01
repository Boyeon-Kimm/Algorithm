import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			pq.add(sc.nextInt());
		}
		StringBuilder sb = new StringBuilder();
		
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.println(sb);
	}
}
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		while(!q.isEmpty()) {
			for(int i = 1; i < K; i++) {
				q.add(q.poll());
			}
			if(q.size() == 1){
				sb.append(q.poll()).append(">");
			} else {
				sb.append(q.poll()).append(", ");
			}
		}
		System.out.println(sb);
	}
}
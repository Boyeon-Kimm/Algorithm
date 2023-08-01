import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			deque.add(i);
		}
		StringBuilder sb = new StringBuilder();
		while(deque.size() != 1) {
			sb.append(deque.removeFirst()).append(" ");
			deque.addLast(deque.removeFirst());
		}
		sb.append(deque.remove());
		System.out.println(sb);
	}
}
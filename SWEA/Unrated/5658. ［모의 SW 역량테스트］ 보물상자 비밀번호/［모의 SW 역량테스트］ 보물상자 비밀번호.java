import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			Queue<String> q = new LinkedList<>();
			List<Integer> list = new ArrayList<>();
			Set<Integer> set = new HashSet<>();
			String[] str = sc.next().split("");
			for(int i = 0; i < N; i++) {
				q.offer(str[i]);
			}
			for(int k = 0; k < N / 4; k++) {
				if(k >= 1) q.offer(q.poll());
				for(int j = 0; j < 4; j++) {
					StringBuilder sb = new StringBuilder();
					for(int i = 0; i < N / 4; i++) {
						sb.append(q.peek());
						q.offer(q.poll());
					}
					set.add(Integer.parseInt(sb.toString(), 16));
				}
			}
			list.addAll(set);
			Collections.sort(list, Collections.reverseOrder());

			System.out.printf("#%d %d\n", tc, list.get(K-1));
		}
	}
}
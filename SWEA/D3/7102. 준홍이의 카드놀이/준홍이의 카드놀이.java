import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();

			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= m; j++) {
					queue.offer(i + j);
				}
			}

			int[] arr = new int[n + m + 1];
			int max = 0;
			while(!queue.isEmpty()) {
				arr[queue.poll()] += 1;
			}
			for(int i = 0; i < arr.length; i++) {
				max = Math.max(max, arr[i]);
			}
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for(int i = 0; i < arr.length; i++) {
				if(max == arr[i]) {
					pq.offer(i);
				}
			}
			System.out.print("#" + tc + " ");
			while(!pq.isEmpty())
				System.out.print(pq.poll() + " ");
			System.out.println();
		}
		sc.close();
	}
}
import java.util.LinkedList;
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
			Queue<Integer> q = new LinkedList<>();
			int[] arr = new int[5001];

 			for(int nc = 0; nc < n; nc++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				for(int i = a; i <= b; i++) {
					arr[i] += 1;
				}
 			}
 			int p = sc.nextInt();
 			for(int i = 0; i < p; i++) {
 				q.offer(sc.nextInt());
 			}
 			System.out.print("#" + tc + " ");
 			while(!q.isEmpty()) {
 				System.out.printf("%d ", arr[q.poll()]);
 			}
 			System.out.println();

		}
	}
}
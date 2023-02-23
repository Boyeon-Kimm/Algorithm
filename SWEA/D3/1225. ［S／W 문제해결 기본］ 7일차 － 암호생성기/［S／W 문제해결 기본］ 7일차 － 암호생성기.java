import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Queue;
import java.util.LinkedList;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			for(int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());
			}
			boolean flag = true;

			while(flag) {
				for(int i = 1; i <= 5; i++) {
					if(q.peek() - i > 0) {
						q.offer(q.poll() - i);
					}
					else {
						q.poll();
						q.offer(0);
						flag = false;
						break;
					}
				}
			}
			System.out.print("#" + tc + " ");
			while(!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
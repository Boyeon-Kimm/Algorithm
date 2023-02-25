import java.util.Collections;
import java.util.PriorityQueue;
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
			int[] arr = new int[n];
			
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < n - 1; i++) {
				for(int j = i + 1; j < n; j++) {
					queue.offer(arr[i] * arr[j]);
					boolean flag = true;
					String str = Integer.toString(queue.poll());
					for(int k = 0; k < str.length() - 1; k++) {
						if(str.charAt(k) - '0' > str.charAt(k + 1) - '0') {
							flag = false;
							break;
						}
					}
					if(flag) {
						if(max < Integer.parseInt(str)) max = Integer.parseInt(str);
					} 
				}
			}
			if(max == Integer.MIN_VALUE) System.out.printf("#%d %s\n", tc, -1);
			else System.out.printf("#%d %s\n", tc, max);
		}
	}
}
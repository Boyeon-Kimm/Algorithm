import java.util.Queue;
import java.util.LinkedList;
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
			String arr[] = new String[n];
			
  			for(int i = 0; i < n; i++) {
				arr[i] = sc.next();
			}
  			
  			Queue<String> q1 = new LinkedList<>();
  			Queue<String> q2 = new LinkedList<>();
  			Queue<String> result = new LinkedList<>();
  			
  			for(int i = 0; i < n; i++) {
  				if(i < (n+1) / 2) q1.offer(arr[i]);
  				else if(i >= n / 2)q2.offer(arr[i]);
  			}
  			
  			while(result.size() < n) {
  				result.offer(q1.poll());
  				if(!q2.isEmpty()) {
  					result.offer(q2.poll());
  				}
  			}
  			
			System.out.print("#"+tc+" ");
			while(!result.isEmpty()) {
				System.out.print(result.poll()+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
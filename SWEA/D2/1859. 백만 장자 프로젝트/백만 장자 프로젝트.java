import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			long benefit = 0;
			int idx = -1;
			boolean flag = true;
			while(flag) {
				int buy = 0;
				int max = 0;
				int temp = idx + 1;
				for(int i = idx + 1; i < N; i++) {
					if(max < arr[i]) {
						max = arr[i];
						idx = i;
					}
				}
				for(int i = temp; i < idx; i++) {
					buy += arr[i];
				}
				benefit += (idx - temp) * max - buy;
				if(idx == N - 1) {
					flag = false;
					break;
				}
			}
			System.out.printf("#%d %d\n", tc, benefit);
		}
	}
}
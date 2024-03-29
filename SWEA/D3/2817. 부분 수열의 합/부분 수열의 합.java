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
			int K = sc.nextInt();
			int[] arr = new int[N];
			int cnt = 0;

			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			for(int i = 0; i < (1 << N); i++) {
				int sum = 0;
				for(int j = 0; j < N; j++) {
					if((i & (1 << j)) > 0) {
						sum += arr[j];
					}
				}
				if(sum == K) cnt++;
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}
}
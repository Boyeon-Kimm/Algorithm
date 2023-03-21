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
			int L = sc.nextInt();
			
			int[] score = new int[N];
			int[] calorie = new int[N];
			
			for(int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				calorie[i] = sc.nextInt();
			}

			int max = 0;
			for(int i = 0; i < (1 << N); i++) {
				int sumSco = 0;
				int sumCal = 0;
				for(int j = 0; j < N; j++) {
					if((i & (1 << j)) > 0) {
						sumSco += score[j];
						sumCal += calorie[j];
					}
				}
				if(sumCal <= L && sumSco > max) {
					max = sumSco;
				}
			}
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
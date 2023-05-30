import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int[][] arr = new int[100][100];
			
			sc.nextInt();
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int max = Integer.MIN_VALUE;
			int right = 0, left = 0;
			for(int i = 0; i < 100; i++) {
				int rowSum = 0, colSum = 0;
				for(int j = 0; j < 100; j++) {
					
					rowSum += arr[i][j];
					colSum += arr[j][i];
					
					if(i == j) right += arr[i][j];
					if(i + j == 99) left += arr[i][j];
				}
				max = Math.max(max, Math.max(Math.max(rowSum, colSum), Math.max(right, left)));
			}
			System.out.printf("#%d %d\n", tc, max);
		}
	}
}
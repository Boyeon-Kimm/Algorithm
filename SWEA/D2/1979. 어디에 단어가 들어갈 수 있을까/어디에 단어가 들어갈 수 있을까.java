import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for(int i = 1; i <= t; i++) {
			String n = sc.next();
			int N = Integer.parseInt(n);
			int numK = sc.nextInt();
			int[][] puzzle = new int[N][N];
			int result = 0;
            
			for(int j = 0; j < puzzle.length; j++) {
				for(int k = 0; k < puzzle.length; k++) {
					puzzle[j][k] = sc.nextInt();
				}
			}
			for(int j = 0; j < puzzle.length; j++) {
				int count = 0;
				for(int k = 0; k < puzzle.length; k++) {
					if(puzzle[j][k] == 1) count++;
					if(puzzle[j][k] == 0 || k == N - 1) {
						if(count == numK) result++;
						count = 0;
					}
				}
			}

			for(int j = 0; j < puzzle.length; j++) {
				int count = 0;
				for(int k = 0; k < puzzle.length; k++) {
					if(puzzle[k][j] == 1) count++;
					if(puzzle[k][j] == 0 || k == N - 1){
						if(count == numK) result++;
						count = 0;
					}
				}
			}
			System.out.println("#"+i+" "+result);
		}
	}
}
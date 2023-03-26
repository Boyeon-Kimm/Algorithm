import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	static int N, count;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[N];
			count = 0;
			
			nQueen(0);
			System.out.printf("#%d %d\n", tc, count);
		}

	}

	private static void nQueen(int idx) {
		if(idx == N) {
			count++;
			return;
		}
		for(int i = 0; i < N; i++) {
			arr[idx] = i;
			if(possibility(idx)) {
				nQueen(idx + 1);
			}
		}
	}

	private static boolean possibility(int idx) {
		for(int i = 0; i < idx; i++) {
			if(arr[idx] == arr[i]) {
				return false;
			}
			else if(Math.abs(idx - i) == Math.abs(arr[idx] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}
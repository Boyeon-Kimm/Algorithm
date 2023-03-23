import java.util.Scanner;

public class Solution {
	static int[] gyuCard, inCard, result;
	static boolean[] visited, arr;
	static int win, lose, gyuSum, inSum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++) {
			gyuCard = new int[9];
			inCard = new int[9];
			result = new int[9];
			visited = new boolean[9];
			arr = new boolean[19];
			win = 0;
			lose = 0;
			gyuSum = 0;
			inSum = 0;

			for(int i = 0; i < 9; i++) {
				gyuCard[i] = sc.nextInt();
				arr[gyuCard[i]] = true;
			}
			int idx = 0;
			for(int i = 1; i < arr.length; i++) {
				if(!arr[i]) {
					inCard[idx++] = i;
				}
			}
			perm(0);
			System.out.printf("#%d %d %d\n", tc, win, lose);
		}
	}
	private static void perm(int n) {
		if(n == 9) {
			gyuSum = 0;
			inSum = 0;
			for(int i = 0; i < 9; i++) {
				if(gyuCard[i] > result[i]) {
					gyuSum += gyuCard[i] + result[i];
				}else if(gyuCard[i] < result[i]) {
					inSum += gyuCard[i] + result[i];
				}
			}
			if(gyuSum > inSum) win++;
			else if(gyuSum < inSum) lose++;
			return;
		}

		for(int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			result[n] = inCard[i];
			visited[i] = true;
			perm(n + 1);
			visited[i] = false;
		}
	}
}

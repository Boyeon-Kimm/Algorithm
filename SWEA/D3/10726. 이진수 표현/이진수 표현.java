import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			String str = Integer.toBinaryString(M);
			String[] arr = str.split("");
			String ans = "OFF";
			int cnt = 0;
			for(int i = arr.length - 1; i >= arr.length - N; i--) {
				if(i < 0) break;
				if(arr[i].equals("0")) break;
				else cnt++;
			}
			if(cnt == N) ans = "ON";
			System.out.printf("#%d %s\n", tc, ans);
		}
	}
}
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() + 1000000;
		long[] dp = new long[2000001];
		long mod = 1000000000;
		
		dp[1000000] = 0;
		dp[1000001] = 1;
		
		if(n < 1000000) {
			for(int i = 999999; i >= n; i--) {
				dp[i] = (dp[i + 2] - dp[i + 1]) % mod;
			}
		}
		else {
			for(int i = 1000002; i <= n; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
			}
		}
		
		if(dp[n] == 0) System.out.println("0");
		else if(dp[n] > 0) System.out.println("1");
		else System.out.println("-1");
		
		System.out.println(Math.abs(dp[n]));
	}
}
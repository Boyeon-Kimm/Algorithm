import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[11];
        dp[2] = 1;

        for(int i = 3; i <= N; i++) {
            dp[i] = i - 1 + dp[i - 1];
        }
        System.out.println(dp[N]);
    }
}
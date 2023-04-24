import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			num[i] = i;
		}
		
		int start = 0, end = 0;
		int cnt = 1, sum = 0;
		
		while(end <= N - 1) {
			if(sum == N) {
				++cnt;
				++end;
				sum += num[end];
			} else if(sum < N) {
				++end;
				sum += num[end];
			} else if(sum > N) {
				sum -= num[start];
				++start;
			}
		}
		System.out.println(cnt);
	}
}
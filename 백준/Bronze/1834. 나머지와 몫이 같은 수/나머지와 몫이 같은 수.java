import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long sum = 0;
		
		for(long i = 1; i < N; i++) {
			sum += (N * i) + i;
		}
		System.out.println(sum);
		sc.close();
	}
}
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long S = sc.nextLong();
		long num = 1;
		long sum = 0;
		
		while(sum <= S) {
			sum += num;
			if(sum > S) break;
			num++;
		}
		System.out.println(num - 1);
	}
}
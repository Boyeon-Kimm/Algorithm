import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int revA = 0, revB = 0;
		
		while(B != 0) {
			revA = revA * 10 + A % 10;
			A /= 10;
			revB = revB * 10 + B % 10;
			B /= 10;
		}
		System.out.println(Math.max(revA, revB));
	}
}
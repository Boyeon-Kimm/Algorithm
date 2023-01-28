import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int over = B + C;
		int cnt = over / 60;
		
		if(cnt != 0) {
			A = cnt + A;
			B = over - (60 * cnt);
			
			if(A > 23) {
				A = A - 24;
				B = over - (60 * cnt);
			}
			System.out.println(A + " " + B);
		} else {
			System.out.println(A + " " + over);
		}
	}
}
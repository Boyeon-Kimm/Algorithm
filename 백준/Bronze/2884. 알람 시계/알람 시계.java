import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		int early = M - 45;
		if(early < 0) {
			if(H == 0) {
				M = M + 15;
				H = 23;
				System.out.print(H);
				System.out.print(" "+ M);
			} else {
				M = M + 15;
				H = H - 1;
				System.out.print(H);
				System.out.print(" " + M);
			}
		} else { 
			System.out.print(H);
			System.out.print(" "+early);
		}
	}
}
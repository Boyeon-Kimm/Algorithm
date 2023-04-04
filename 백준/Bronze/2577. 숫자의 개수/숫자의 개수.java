import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int mul = A * B * C;
		int length = (int)(Math.log10(mul) + 1);
		int[] counting = new int[10];
		int cnt = 0;
		
		for(int i = 0; i < length; i++) {
			counting[mul % 10]++;
			mul /= 10;
		}
		for(int c : counting)
			System.out.println(c);
	}
}
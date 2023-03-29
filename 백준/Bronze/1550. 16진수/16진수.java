import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String c = sc.next();
		int res = Integer.parseInt(c, 16);
		System.out.println(res);
	}
}
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char[] arr = str.toCharArray();
		
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += Math.pow((int)arr[i] - '0', 5);
		}
		System.out.println(sum);
	}
}
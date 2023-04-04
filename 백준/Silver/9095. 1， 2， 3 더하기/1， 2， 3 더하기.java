import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = new int[11];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			for(int j = 4; j <= N; j++) {
				arr[j] = arr[j - 3] + arr[j - 2] + arr[j - 1];
			}
			System.out.println(arr[N]);
		}
	}
}
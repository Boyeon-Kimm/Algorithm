import java.util.Scanner;

public class Main {
	static int N;
	static int cnt = 0;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		nQueen(0);
		System.out.println(cnt);
	}
	private static void nQueen(int idx) {
		if(idx == N) {
			cnt++;
			return;
		}
		for(int i = 0; i < N; i++) {
			arr[idx] = i;
			if(possibility(idx)) {
				nQueen(idx + 1);
			}
		}
	}
	private static boolean possibility(int idx) {
		for(int i = 0; i < idx; i++) {
			if(arr[idx] == arr[i]) {
				return false;
			}
			else if(Math.abs(idx - i) == Math.abs(arr[idx] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}

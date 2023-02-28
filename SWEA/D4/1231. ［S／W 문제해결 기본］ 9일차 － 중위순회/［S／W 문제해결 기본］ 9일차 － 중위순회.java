import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int N;
	static String[] arr;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(sc.nextLine());
			arr = new String[N + 1];

			for(int info = 1; info <= N; info++) {
				String[] str = sc.nextLine().split(" ");
				arr[info] = str[1];
 			}
			System.out.print("#" + tc + " ");
			traverse(1);
			System.out.println();
		}
	}
    private static void traverse(int i) {
		if(i <= N) {
			traverse(i * 2);
			if(arr[i] != " ") System.out.print(arr[i]);
			traverse(i * 2 + 1);
		}
	}
}
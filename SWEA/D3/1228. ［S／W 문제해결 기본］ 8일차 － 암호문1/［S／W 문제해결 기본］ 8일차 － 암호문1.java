import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			List<Integer> list = new LinkedList<>();
			int N = sc.nextInt();
			for(int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			int ca = sc.nextInt();
			for(int i = 0; i < ca; i++) {
				String str = sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				for(int j = 0; j < y; j++) {
					list.add(x + j, sc.nextInt());
				}
			}
			System.out.printf("#%d ", tc);
			for(int i = 0; i < 10; i++) {
				System.out.printf("%d ", list.get(i));
			}
			System.out.println();
		}
	}
}
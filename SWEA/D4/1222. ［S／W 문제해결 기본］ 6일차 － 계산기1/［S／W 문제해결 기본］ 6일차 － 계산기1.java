import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			String str = sc.next();
			char[] arr = str.toCharArray();
			char[] num = new char[arr.length - 1];
			Stack<Character> stack = new Stack<>();
			int j = 0;

			for(int i = 0; i < arr.length; i++) {
				if(arr[i] != '+') {
					num[j] = arr[i];
					j++;
				} else {
					if(!stack.isEmpty()) {
						num[j] = arr[i];
						j++;
					}
					else stack.push(arr[i]);
				}
			}
			Stack<Integer> sumStack = new Stack<>();
			for(int i = 0; i < num.length; i++) {
				if(num[i] != '+') {
					if(!sumStack.isEmpty()) {
						sumStack.push(num[i] - '0' + sumStack.pop());
					} else sumStack.push(num[i] - '0');
				} else continue;
			}
			System.out.printf("#%d %d\n", tc, sumStack.pop());
 		}
	}
}
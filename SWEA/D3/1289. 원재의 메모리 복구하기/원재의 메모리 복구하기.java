import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// t번의 테스트 케이스
		for(int tc = 1; tc <= t; tc++) {
			char[] memory = sc.next().toCharArray();
			Stack<Character> stack = new Stack<>();
			int cnt = 0;
			for(int i = 0; i < memory.length; i++) {
				if(!stack.isEmpty()) { 
					if(memory[i] == stack.peek()) stack.push(memory[i]);
					else {
						cnt++;
						stack.push(memory[i]);
					}
				} else {
					if(memory[i] == '1') {
						cnt++;
						stack.push(memory[i]);
					} else stack.push(memory[i]);
				}
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
		sc.close();
	}
}
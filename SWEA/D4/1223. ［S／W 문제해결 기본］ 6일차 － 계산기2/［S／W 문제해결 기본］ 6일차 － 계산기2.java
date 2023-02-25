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
			Stack<Character> stack = new Stack<>();
			Stack<Integer> calStack = new Stack<>();
			char[] nums = new char[arr.length];
			int j = 0;
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] != '+' && arr[i] != '*') {
					nums[j] = arr[i];
					j++;
				} else {
					if(stack.isEmpty()) stack.push(arr[i]);
					else {
						if(arr[i] > stack.peek()) {
							nums[j] = stack.pop();
							++j;
							nums[j] = arr[i];
							j++;
						} else if (arr[i] < stack.peek()) {
							stack.push(arr[i]);
						} else {
							nums[j] = arr[i];
							j++;
						}
					}
				}
			}
			while(!stack.isEmpty()) {
				for(int i = 0; i < stack.size(); i++) {
					nums[nums.length - stack.size() + i] = stack.pop();
				}
			}
			
			for(int i = 0; i < nums.length; i++) {
				if(nums[i] != '+' && nums[i] != '*') calStack.push(nums[i] - '0');
				else {
					if(nums[i] == '*')
						calStack.push(calStack.pop() * calStack.pop());
					else {
						if(calStack.size() > 1)
							calStack.push(calStack.pop() + calStack.pop());
					}
				}
			}
			int calculate = 0;
			if(!calStack.isEmpty()) {
				for(int i = 0; i < calStack.size(); i++) {
					calculate += calStack.get(i);
				}
			}
			System.out.printf("#%d %d\n", tc, calculate);
		}
		sc.close();
	}
}
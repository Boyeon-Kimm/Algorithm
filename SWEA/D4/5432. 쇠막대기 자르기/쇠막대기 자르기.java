import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 1; tc <= t; tc++){
        	String str = sc.next();
            char[] arr = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            int pieces = 0;
            
            for(int i = 0; i < arr.length; i++){
            	if(arr[i] == '(') stack.push(arr[i]);
                else if(arr[i] == ')' && arr[i - 1] == '('){
                	stack.pop();
                    pieces += stack.size();
                } else if(arr[i] == ')' && arr[i - 1] == ')'){
                	stack.pop();
                    pieces += 1;
                }
            }
         	System.out.printf("#%d %d\n", tc, pieces);
        }
	}
}
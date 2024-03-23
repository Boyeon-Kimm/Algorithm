import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public String solution(String str, String bomb) {
        String answer = "FRULA";
        Stack<Character> stack = new Stack<>();

        if(str.length() < bomb.length()) return str;
        else {
            for(int i = 0; i < str.length(); i++) {
                stack.add(str.charAt(i));

                if(stack.size() >= bomb.length() && stack.peek() == bomb.charAt(bomb.length() - 1)) {
                    boolean check = false;
                    for(int j = 0; j < bomb.length(); j++) {
                        if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                            check = true;
                            break;
                        }
                    }

                    if(!check) {
                        for(int j = 0; j < bomb.length(); j++) {
                            stack.pop();
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack) {
            sb.append(c);
        }

        return sb.length() == 0 ? answer : sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        Main T = new Main();

        System.out.println(T.solution(str, bomb));
    }
}
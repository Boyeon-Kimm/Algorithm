import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            answer[i] = -1;
        }

        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                answer[stack.pop()] = arr[i];
            }
            stack.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int n : answer) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }

}
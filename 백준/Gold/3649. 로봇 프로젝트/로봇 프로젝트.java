import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public String solution(int x, int n, int[] arr) {
        String answer = "danger";
        Arrays.sort(arr);
        int lt = 0;
        int rt = n - 1;
        boolean flag = false;

        while(lt < rt) {
            int sum = arr[lt] + arr[rt];

            if(sum == x) return "yes " + arr[lt] + " " + arr[rt];
            else if(sum > x) rt--;
            else lt++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        while ((str = br.readLine()) != null) {
            int x = Integer.parseInt(str);
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

            Main T = new Main();
            System.out.println(T.solution(x * 10000000, n, arr));
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder total = new StringBuilder();
        StringBuilder now = new StringBuilder();
        boolean flag = false;
        char[] arr = br.readLine().toCharArray();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '<') {
                flag = true;
                total.append(now.reverse());
                now = new StringBuilder();
                now.append('<');
            } else if(arr[i] == '>') {
                flag = false;
                now.append(arr[i]);
                total.append(now);
                now = new StringBuilder();
            } else if(arr[i] == ' ' || i == arr.length - 1) {
                if(flag) {
                    now.append(arr[i]);
                } else {
                    if(i == arr.length - 1) {
                        now.append(arr[i]);
                        total.append(now.reverse());
                    } else {
                        total.append(now.reverse()).append(' ');
                    }
                    now = new StringBuilder();
                }
            } else {
                now.append(arr[i]);
            }
        }
        System.out.println(total);
    }
}
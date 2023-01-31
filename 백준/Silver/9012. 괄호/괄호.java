import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++){
            char[] arr = br.readLine().toCharArray();
            int cnt = 0;
            for(char c : arr){
                if(cnt >= 0){
                    if(c == '(') cnt++;
                    else if(c == ')') cnt--;
                } else break;
            }
            if(cnt == 0) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}
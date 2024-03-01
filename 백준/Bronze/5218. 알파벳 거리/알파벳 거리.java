import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] arr1 = st.nextToken().toCharArray();
            char[] arr2 = st.nextToken().toCharArray();
            sb.append("Distances:");

            for(int i = 0; i < arr1.length; i++) {
                if(arr1[i] <= arr2[i]) sb.append(" ").append((arr2[i] - 48) - (arr1[i] - 48));
                 else sb.append(" ").append((arr2[i] - 22) - (arr1[i] - 48));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
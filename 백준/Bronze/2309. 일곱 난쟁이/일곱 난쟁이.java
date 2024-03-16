import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarf = new int[9];
        int sum = 0;

        for(int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
            sum += dwarf[i];
        }
        int num = sum;

        outer:
        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                sum -= (dwarf[i] + dwarf[j]);
                if(sum == 100) {
                    dwarf[i] = 0;
                    dwarf[j] = 0;
                    break outer;
                }
                sum = num;
            }
        }
        Arrays.sort(dwarf);
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < 9; i++) {
            sb.append(dwarf[i]).append("\n");
        }
        System.out.println(sb);
    }
}
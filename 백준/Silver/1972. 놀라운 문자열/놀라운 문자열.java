import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while(!(str = br.readLine()).equals("*")) {
            int result = 0;
            int num = 0;
            for(int i = 1; i < str.length(); i++) {
                num += i;
            }

            Set<String> set = new HashSet<>();

            if(str.length() <= 2) {
                System.out.println(str + " is surprising.");
            } else {
                for(int i = 1; i <= str.length() - 1; i++) {
                    for(int j = 0; j < str.length() - i; j++) {
                        String first = String.valueOf(str.charAt(j));
                        String second = String.valueOf(str.charAt(i + j));
                        set.add(first + second);
                    }
                    result += set.size();
                    set.clear();
                }
                if(result == num) System.out.println(str + " is surprising.");
                else System.out.println(str + " is NOT surprising.");
            }
        }
    }
}
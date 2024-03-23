import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            if(str.equals("end")) break;
            boolean vFlag = false;
            boolean vcFlag = true;
            boolean eoFlag = true;
            int vCnt = 0;
            int cCnt = 0;

            outer:
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                    vFlag = true;
                    vCnt++;
                    cCnt = 0;
                    if(vCnt >= 3) {
                        vcFlag = false;
                        break outer;
                    }
                } else {
                    cCnt++;
                    vCnt = 0;
                    if(cCnt >= 3) {
                        vcFlag = false;
                        break outer;
                    }
                }

                if(i >= 1) {
                    if(str.charAt(i) != 'e' && str.charAt(i) != 'o' && str.charAt(i) == str.charAt(i - 1)) {
                        eoFlag = false;
                        break outer;
                    } else eoFlag = true;
                }
            }
            if(vFlag && vcFlag && eoFlag) System.out.println("<" + str + ">" + " is acceptable.");
            else System.out.println("<" + str + ">" + " is not acceptable.");
        }
    }
}
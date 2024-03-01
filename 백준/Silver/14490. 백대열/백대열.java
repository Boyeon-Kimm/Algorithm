import java.io.IOException;
import java.util.Scanner;

public class Main {
    static String[] str = new String[2];
    static int n = 0;
    static int m = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine().split(":");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        int answer = gdc(Math.max(n, m), Math.min(n, m));
        System.out.println(n / answer + ":" + m / answer);
    }
    public static int gdc(int a, int b) {
        if(a % b == 0) return b;

        return gdc(b, a % b);
    }
}
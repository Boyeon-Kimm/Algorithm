import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int deno = b * d;
        int num = (a * d) + (b * c);

        int answer = gdc(Math.max(deno, num), Math.min(deno, num));
        System.out.println(num / answer + " " + deno / answer);
    }

    static int gdc(int a, int b) {
        if(a % b == 0) return b;
        return gdc(b, a % b);
    }
}
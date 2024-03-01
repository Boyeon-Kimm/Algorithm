import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int answer = gdc(Math.max(n, m), Math.min(n, m));
        System.out.println(answer);
        System.out.println(answer * (n / answer) * (m / answer));
    }

    public static int gdc(int a, int b) {
        if(a % b == 0) return b;

        return gdc(b, a % b);
    }
}
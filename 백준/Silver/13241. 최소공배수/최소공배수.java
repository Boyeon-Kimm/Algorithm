import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        long answer = gdc(Math.max(a, b), Math.min(a, b));
        System.out.println(answer * (a / answer) * (b / answer));
    }

    public static long gdc(long a, long b) {
        if(b == 0) return a;

        return gdc(b, a % b);
    }
}
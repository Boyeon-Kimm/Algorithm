import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int n = 0, m = 0;

        while(tc-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();

            int answer = gdc(Math.max(n, m), Math.min(n, m));
            System.out.println(n * m / answer);
        }
    }
    public static int gdc(int a, int b) {
        if(b == 0) return a;
        return gdc(b, a % b);
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = 1;
        String str = "";
        String reverse = "";

        outer:
        while(num != 0) {
            num = sc.nextInt();
            if(num == 0) break outer;

            str = String.valueOf(num);
            reverse = new StringBuilder(str).reverse().toString();

            if(str.equals(reverse)) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        System.out.println(sb);
    }
}
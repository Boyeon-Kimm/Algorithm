import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String reverse = new StringBuilder(str).reverse().toString();
        int answer = 0;

        if(str.equals(reverse)) answer = 1;
        System.out.println(answer);
    }
}
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int one = sc.nextInt();
        int two = sc.nextInt();

        int a = two % 10;
        int b = (two - a) % 100;
        int c = (two - a - b) % 1000;

        sb.append(one * a).append("\n").append(one * b / 10).append("\n").append(one * c / 100).append("\n").append(one * two);
        System.out.println(sb);
    }
}
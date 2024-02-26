import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int stick = 64;
        int count = 1;
        int sum = 0;

        while(sum != X && X != stick) {
            stick /= 2;
            sum += stick;
            if(sum > X) sum -= stick;
            else if(sum < X) count++;
        }
        System.out.println(count);
    }
}
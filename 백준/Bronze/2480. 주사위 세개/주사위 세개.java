import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int max;
        
        if(a != b && a != c && b != c){
            if(a < b){
                if(b < c){
                    max = c;
                } else max = b;
            } else {
                if(a > c){
                    max = a;
                } else max = c;
            }
            System.out.println(max * 100);
        } else {
            if(a == b && a == c){
                System.out.println(a * 1000 + 10000);
            } else {
                if(a == b || a == c){
                    System.out.println(a * 100 + 1000);
                } else System.out.println(b * 100 + 1000);
            }
        }
    }
}
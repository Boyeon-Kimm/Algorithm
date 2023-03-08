import java.util.Scanner;
public class Main{
    static int n, m;
    static int[] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        
        bt(0, 0);
    }
    static void bt(int idx, int num){
        if(idx == m){
            for(int k : arr){
                System.out.print(k + " ");
            }
            System.out.println();
        } else {
            for(int i = num + 1; i <= n; i++){
                arr[idx] = i;
                bt(idx + 1, i);
            }
        }
    }
}
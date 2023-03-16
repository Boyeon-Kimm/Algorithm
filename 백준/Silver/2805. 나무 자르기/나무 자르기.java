import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N+1];
        
        long max = 0;
        for(int i = 1; i <= N; i++){
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        long end = max;
        long start = 0;
        
        while(start <= end){
            long middle = (start + end) / 2;
            long sum = 0;
            
            for(int a : arr){
                if(a > middle){
                    sum += a - middle;
                }
            }
            if(sum >= M) start = middle + 1;
            else end = middle - 1;
        }
        System.out.println(end);
    }

}
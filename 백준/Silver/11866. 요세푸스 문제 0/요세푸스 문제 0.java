import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            q.add(i);
        }
        System.out.print("<");
        while(N-- > 0){
           for(int i = 0; i < K; i++){
               if(i == K - 1){
                   if(N == 0) System.out.print(q.poll());
                   else System.out.print(q.poll() + ", ");
               } else {
                   q.add(q.poll());
               }
           }
        }
        System.out.print(">");
        sc.close();
    }
}
import java.util.Scanner;
import java.util.Stack;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        
        Stack<Integer> st = new Stack<>();
        int sum = 0;
        
        for(int i = 0; i < K; i++){
            int num = sc.nextInt();
            if(num == 0){
                if(!st.isEmpty()){
                    st.pop();
                } else {
                    continue;
                }
            } else {
                st.push(num);
            }
        }
        while(!st.isEmpty()){
            sum += st.pop();
        }
        System.out.println(sum);
    }
}
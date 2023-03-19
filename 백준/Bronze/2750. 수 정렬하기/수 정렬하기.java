import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static int N;
    public static int[] arr;
    public static int[] temp;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        temp = new int[N];
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        mergeSort(0, N - 1);
        printArr(arr);
        
    }
    
    public static void mergeSort(int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            
            int p = start;
            int q = mid + 1;
            int idx = start;
            
            while(p <= mid || q <= end){
                if(q > end || (p <= mid && arr[p] < arr[q])){
                    temp[idx++] = arr[p++];
                } else {
                    temp[idx++] = arr[q++];
                }
            }
            for(int i = start; i <= end; i++){
                arr[i] = temp[i];
            }
        }
    }
    public static void printArr(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}
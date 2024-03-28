import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<BigDecimal> list = new ArrayList<>();

        while(N-- > 0) {
            String str = br.readLine().replaceAll("[^0-9]", " ");
            String[] arr = str.split(" ");

            for(int i = 0; i < arr.length; i++) {
                if(!arr[i].equals("")) list.add(new BigDecimal(arr[i]));
            }
        }
        Collections.sort(list);
        for(BigDecimal n : list) {
            System.out.println(n);
        }
    }
}
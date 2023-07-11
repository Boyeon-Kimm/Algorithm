import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            String[] name = br.readLine().split(" ");
            if(name[1].equals("enter")) {
                set.add(name[0]);
            } else {
                set.remove(name[0]);
            }
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        for(String s: list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
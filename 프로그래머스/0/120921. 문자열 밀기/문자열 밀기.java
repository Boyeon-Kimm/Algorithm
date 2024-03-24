import java.util.*;
import java.io.*;

class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        
        if(A.equals(B)) return 0;
        else {
            StringBuilder sb = new StringBuilder(B);
            for(int i = 0; i < B.length(); i++) {
                if(sb.toString().equals(A)) break;
                else {
                    sb.append(sb.charAt(0));
                    sb.deleteCharAt(0);
                    answer++;
                }
            }
        }
        return answer == B.length() ? -1 : answer;
    }
}
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        int answer = 1;
        
        for(int value : map.values()) {
            answer *= (value + 1);
        }
        return answer - 1;
    }
}
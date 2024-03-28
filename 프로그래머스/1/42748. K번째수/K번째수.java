import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        
        for(int tc = 0; tc < commands.length; tc++) {
            List<Integer> temp = new ArrayList<>();
            
            for(int i = commands[tc][0] - 1; i < commands[tc][1]; i++) {
                temp.add(array[i]);
            }
            Collections.sort(temp);
        
            answer[idx++] = temp.get(commands[tc][2] - 1);
        }
        
        return answer;
    }
}
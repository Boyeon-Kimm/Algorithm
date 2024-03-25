import java.util.*;

class Solution {
    int[][] key = {
            {3, 1}, // 0
            {0, 0},
            {0, 1},
            {0, 2},
            {1, 0},
            {1, 1},
            {1, 2},
            {2, 0},
            {2, 1},
            {2, 2},
        };
        
    int[] leftLo = {3, 0};
    int[] rightLo = {3, 2};
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        for(int n : numbers) {
            switch(n) {
                case 1: case 4: case 7:
                    answer.append("L");
                    leftLo = key[n];
                    break;
                    
                case 3: case 6: case 9:
                    answer.append("R");
                    rightLo = key[n];
                    break;
                    
                default:
                    int leftDist = getDist(leftLo, key[n]);
                    int rightDist = getDist(rightLo, key[n]);
                    
                    if(leftDist < rightDist || (leftDist == rightDist && hand.equals("left"))) {
                        answer.append("L");
                        leftLo = key[n];
                    } else {
                        answer.append("R");
                        rightLo = key[n];
                    }
                    break;
            }
        }
        return answer.toString();
    }
    
    public int getDist(int[] key1, int[] key2) {
        return Math.abs(key1[0] - key2[0]) + Math.abs(key1[1] - key2[1]);
    }
}
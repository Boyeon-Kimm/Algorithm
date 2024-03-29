class Solution {
    public String solution(int a, int b) {
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        int total = b;
        for(int i = 0; i < a; i++) {
            total += month[i];
        }
        String answer = days[total % 7];
        return answer;
    }
}
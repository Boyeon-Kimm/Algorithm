class Solution {
    public int solution(int hp) {
        int answer = 0;
        answer = hp / 5;
        hp -= answer * 5;
        answer += hp / 3;
        hp -= hp / 3 * 3;
        if(hp > 0) answer += hp;
        return answer;
    }
}
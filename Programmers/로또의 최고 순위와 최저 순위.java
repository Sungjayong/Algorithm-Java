import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] winNums) {
        int zeroCount = 0;
        int matchedCount = 0;
        boolean[] isLotto = new boolean[46];
        boolean[] isWinNum = new boolean[46];
        
        for(int lotto : lottos) { 
            isLotto[lotto] = true; 
            if(lotto == 0) zeroCount++;
        }
        for(int winNum : winNums) { isWinNum[winNum] = true; }
        
        for(int i = 1; i < 46; i++) {
            if(isLotto[i] && isWinNum[i]) matchedCount++;
        }
        
        int[] answer = new int[]{getPrice(matchedCount), getPrice(matchedCount + zeroCount)};
        Arrays.sort(answer); 
        return answer;
    }
    
    int getPrice(int count) {
        //0개 일치 시 7등이 아니라 6등임.
        if(count == 0) return 6;
        return 7 - count;
    }
}
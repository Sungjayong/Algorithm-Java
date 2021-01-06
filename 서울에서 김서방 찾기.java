package com.company;

class Solution {
    public String solution(String[] seoul) {
        int idx = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                idx = i;
                break;
            }
        }
        String answer = "김서방은 " + Integer.toString(idx) + "에 있다";
        return answer;
    }
}

public class main {
    public static void main(String[] args) {
        // write your code here
        Solution s = new Solution();
        String seoulPeople = {"Jane", "Cin", "Kim"};
        System.out.println(s.solution(seoulPeople));
    }
}
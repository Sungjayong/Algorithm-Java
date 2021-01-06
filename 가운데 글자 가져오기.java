package com.company;

class Solution {
    public String solution(String s) {
        int len = s.length();
        String answer = (len % 2 == 1) ? s.substring(len/2,len/2+1) : s.substring(len/2-1, len/2+1);
        return answer;
    }
}

public class main {
    public static void main(String[] args) {
        // write your code here
        Solution s = new Solution();
        System.out.println(s.solution("ABDCE"));
    }
}


package com.company;

class Solution {
    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        sb.append((n%2 == 0) ? "수박".repeat(n/2) : "수박".repeat(n/2)+ "수");
        return sb.toString();
    }
}

public class main {
    public static void main(String[] args) {
        // write your code here
        Solution s = new Solution();
        System.out.println(s.solution(3));
    }
}

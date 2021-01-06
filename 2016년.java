package com.company;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(int a, int b) {
        String[] dayArray = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int sum = 0;
        Map<Integer, Integer> monthMap = new HashMap<>();
        monthMap.put(1,31);
        monthMap.put(2,29);
        monthMap.put(3,31);
        monthMap.put(4,30);
        monthMap.put(5,31);
        monthMap.put(6,30);
        monthMap.put(7,31);
        monthMap.put(8,31);
        monthMap.put(9,30);
        monthMap.put(10,31);
        monthMap.put(11,30);
        monthMap.put(12,31);
        for (int i = 1; i< a; i++) {
            sum += monthMap.get(i);
        }
        sum += b;
        return dayArray[sum%7];
    }
}

public class main {
    public static void main(String[] args) {
        // write your code here
        Solution s = new Solution();
        System.out.println(s.solution(2,8));
    }
}
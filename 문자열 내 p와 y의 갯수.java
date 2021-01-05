package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution s = new Solution();
        System.out.println(s.solution("PyPPyYYadb"));
    }
}
//소문자 변환 함수 : toLowerCase(), 문자열의 길이 반환 : .length()
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String lowercases = s.toLowerCase();
        int pcount = 0; //p의 갯수
        int ycount = 0; //y의 갯수
        for (int i=0;i<lowercases.length(); i++) {
            if(lowercases.substring(i,i+1).equals("y"))
                ycount++;
            else if(lowercases.substring(i,i+1).equals("p"))
                pcount++;
        }
        if (pcount != ycount)
            answer = false;
        return answer;
    }
}

//feedback : pcount와 ycount 합치기.
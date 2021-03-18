//9935번 : 문자열 폭발
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bangStr = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i <= str.length(); i++) {
            if(stack.size() < bangStr.length()) { //비교 가능할 만큼 스택에 추가.
                stack.push(str.charAt(i));
                continue;
            }
            StringBuilder sb = new StringBuilder("");
            Boolean isMatch = true;
            for (int j = 0; j < bangStr.length(); j++) {//스택에서 문자열을 떼옴.
                char comparedC = stack.elementAt(stack.size() - bangStr.length() + j);
                sb.append(comparedC);
                if(comparedC != bangStr.charAt(j)){ // 한 문자라도 다르면 즉각 중단.
                    isMatch = false;
                    break;
                }
            }
            if(isMatch) {
                for (int j = 0; j < bangStr.length(); j++) {
                    stack.pop();
                }
            }
            try {
                stack.push(str.charAt(i));
            } catch(StringIndexOutOfBoundsException e){
                continue;
            }

        }
        StringBuilder answer = new StringBuilder("");
        if (stack.isEmpty()) answer.append("ALURF");
        while(!stack.isEmpty()){
            answer.append(stack.pop());
        }
        System.out.println(answer.reverse().toString());
    }
}
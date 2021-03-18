//10799번 쇠막대기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int stickNum = 0;
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char cc = (i == s.length() - 1) ? 'x' : s.charAt(i+1);
            if(c == '(') {
                stack.push(c);
                if(cc == ')') { //레이저 생성
                    stack.pop();
                    stickNum += stack.size();
                    i++;
                }
            }
            if(c == ')') {
                stack.pop();
                stickNum += 1;
            }
        }
        System.out.println(stickNum);
    }
}

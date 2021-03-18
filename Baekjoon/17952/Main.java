//17952번 : 과제는 끝나지 않아!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> stack = new Stack<>();
        int minute = Integer.parseInt(br.readLine());
        int score = 0;
        for (int t = 1; t <= minute; t++) {
            String s = br.readLine();
            if(s.equals("0")) {
                if(stack.isEmpty()) continue;
                int[] arr = stack.pop();
                arr[2] -= 1;
                if(arr[2] == 0) {
                    score += arr[1];
                } else{
                    stack.push(arr);
                }
                continue;
            }
            StringTokenizer st = new StringTokenizer(s);
            int hwNum = Integer.parseInt(st.nextToken());
            int hwScore = Integer.parseInt(st.nextToken());
            int hwTime = Integer.parseInt(st.nextToken());
            hwTime -= 1;
            if(hwTime == 0) {
                score += hwScore;
            } else {
                int[] homework = {hwNum, hwScore, hwTime};
                stack.push(homework);
            }
        }
        System.out.println(score);
    }
}

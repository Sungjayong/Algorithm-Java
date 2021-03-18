//2493번 : 탑
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    static class Tower {
        int height;
        int idx;
        Tower(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }
    static int[] heightArr;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Tower> stack = new Stack<>(); //탑의 높이와 위치를 함께 저장함.
        heightArr = new int[n]; //우선 높이를 저장.
        answer = new int[n]; //최종 레이저가 향하는 인덱스 위치.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) { //배열 값 입력.
            heightArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            while(true) {
                //만약 앞에 있는게 더 작으면, 버려버리고 다시 확인.
                if(stack.isEmpty()) { //만약 앞에 더 높은 높이의 탑이 없으면, 0값을 넣어주고, 스택에 추가.
                    answer[i] = 0;
                    stack.push(new Tower(heightArr[i], i));
                    break;
                }
                Tower t = stack.pop();
                if(t.height > heightArr[i]) {
                    stack.push(t);
                    answer[i] = t.idx + 1;
                    stack.push(new Tower(heightArr[i], i));
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}

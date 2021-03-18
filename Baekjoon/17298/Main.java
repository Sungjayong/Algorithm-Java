//17298번 : 오큰수
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder("");
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int answer[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //Processing
        stack.push(0);
        for (int i = 1; i < n; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
            }
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        //Output
        for (int i = 0; i < n; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb.toString());
    }
}

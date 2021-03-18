//1158번. 요세푸스 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int k = Integer.parseInt(st.nextToken()); // 제거할 번수
        StringBuffer sb = new StringBuffer("<");
        for (int i = 1; i <= n; i++) { //우선 1부터 n까지 집어 넣어줌.
            queue.offer(i);
        }
        int num = 0;
        while(!queue.isEmpty()) {
            int q = queue.poll();
            num++;
            if(num % k == 0) {
                if(queue.isEmpty()) sb.append(q + ">"); //마지막 수이면
                else sb.append(q+", ");
            } else {
                queue.offer(q);
            }
        }
        System.out.println(sb.toString());
    }
}

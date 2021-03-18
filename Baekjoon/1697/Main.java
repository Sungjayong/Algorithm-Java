//1697번. 숨바꼭질
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisit = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(bfs(stoi(st.nextToken()),stoi(st.nextToken())));
    }

    private static int bfs(int s, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {s, 0});
        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            if(q[0] == b) return q[1];
            if(q[0] >= 0 && q[0] <= 100000 && !isVisit[q[0]]) {
                isVisit[q[0]] = true;
                queue.offer(new int[] {q[0] + 1, q[1] + 1});
                queue.offer(new int[] {q[0] - 1, q[1] + 1});
                queue.offer(new int[] {2 * q[0], q[1] + 1});
            }
        }
        return -1;
    }
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
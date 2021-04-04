//16953번. A -> B
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int a,b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = stoi(st.nextToken());
        b = stoi(st.nextToken());
        bfs();
        if(b == -1) System.out.println(-1);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisit = new boolean[b + 1];
        queue.offer(a);
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int n = queue.poll();
                if(n == b) {
                    System.out.println(level);
                    return;
                }
                if(n * 2 <= b && !isVisit[n * 2]) {
                    isVisit[n * 2] = true;
                    queue.offer(n * 2);
                }
                if(n < Math.pow(10,8)) {
                    StringBuilder sb = new StringBuilder("");
                    int m = stoi(sb.append(n + "1").toString());
                    if(m <= b && !isVisit[m]) {
                        isVisit[m] = true;
                        queue.offer(m);
                    }
                }
            }
            level++;
        }
        b = -1;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
//11724번. 연결 요소의 개수
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] graph;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        boolean[] isCheck = new boolean[n];
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u-1][v-1] = 1;
            graph[v-1][u-1] = 1;
        }
        //Process
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(isCheck[i]) continue;
            else cnt++;
            queue.offer(i);
            isCheck[i] = true;
            while(!queue.isEmpty()) {
                int a = queue.poll();
                for (int j = 0; j < n; j++) {
                    if(graph[a][j] == 1 && !isCheck[j]) {
                        queue.offer(j);
                        isCheck[j] = true;
                    }
                }
            }
        }
        //Output
        System.out.println(cnt);
    }

}
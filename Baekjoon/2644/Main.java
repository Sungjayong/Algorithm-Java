//2644번. 촌수 계산
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int start;
    static int end;
    static int[][] graph;
    static boolean isFinish;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int num = stoi(br.readLine());
        graph = new int[num + 1][num + 1];
        st = new StringTokenizer(br.readLine());
        start = stoi(st.nextToken());
        end = stoi(st.nextToken());
        int m = stoi(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        bfs();
        if(!isFinish) System.out.println(-1);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean isVisit[] = new boolean[graph.length];
        isFinish = false;

        queue.offer(new int[] {start, 1});
        isVisit[start] = true;

        while(!queue.isEmpty() && !isFinish) {
            int q[] = queue.poll();
            for (int i = 1; i < graph.length; i++) {
                if(graph[q[0]][i] == 1 && !isVisit[i]) {
                    if(i == end) {
                        System.out.println(q[1]);
                        isFinish = true;
                        break;
                    }
                    isVisit[i] = true;
                    queue.offer(new int[] {i, q[1] + 1});
                }
            }
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
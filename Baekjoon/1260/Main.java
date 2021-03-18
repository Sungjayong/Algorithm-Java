//1260번. DFS와 BFS
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] isVisit;
    static StringBuilder sb = new StringBuilder("");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int v = stoi(st.nextToken());
        int e = stoi(st.nextToken());
        int sv = stoi(st.nextToken()) - 1;
        graph = new int[v][v];
        isVisit = new boolean[v];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken()) - 1;
            int b = stoi(st.nextToken()) - 1;
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        sb.append(sv + 1 + " ");
        isVisit[sv] = true;
        dfs(sv);
        System.out.println(sb.toString());

        sb = new StringBuilder("");
        Arrays.fill(isVisit, false);

        sb.append(sv + 1 + " ");
        isVisit[sv] = true;
        bfs(sv);
        System.out.println(sb.toString());
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while(!queue.isEmpty()) {
            int q = queue.poll();
            for (int i = 0; i < graph.length; i++) {
                if(graph[q][i] == 1 && !isVisit[i]) {
                    sb.append(i + 1 + " ");
                    isVisit[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    private static void dfs(int v) {
        for (int i = 0; i < graph.length; i++) {
            if(graph[v][i] == 1 && !isVisit[i]) {
                sb.append(i + 1 + " ");
                isVisit[i] = true;
                dfs(i);
            }
        }
        return;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
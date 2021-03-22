//1753번. 최단경로
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = stoi(st.nextToken());
        int e = stoi(st.nextToken());
        int start = stoi(br.readLine());
        ArrayList<int[]>[] adjList = new ArrayList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        boolean[] isVisit = new boolean[v+1];
        int[] dist = new int[v+1];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int uu = stoi(st.nextToken());
            int vv = stoi(st.nextToken());
            int ww = stoi(st.nextToken());
            adjList[uu].add(new int[] {vv,ww});
        }
        Arrays.fill(dist,INF);
        dist[start] = 0;
        for (int i = 0; i < v; i++) {
            //step 1. 가장 작은 값 찾기.
            int min = INF;
            int current = 0;
            for (int j = 1; j <= v; j++) {
                if(!isVisit[j] && dist[j] < min) {
                    min = dist[j];
                    current = j;
                }
            }
            isVisit[current] = true;
            //step 2. 찾은 current를 경유해서 가장 작은 값 찾기.
            for (int j = 0; j < adjList[current].size(); j++) {
                int arrival = adjList[current].get(j)[0];
                int weight = adjList[current].get(j)[1];
                if(!isVisit[arrival] && dist[arrival] > dist[current] + weight) {
                    dist[arrival] = dist[current] + weight;
                }
            }
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 1; i <= v; i++) {
            if(dist[i] != INF) sb.append(dist[i] + "\n");
            else sb.append("INF\n");
        }
        System.out.println(sb.toString());

    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}




















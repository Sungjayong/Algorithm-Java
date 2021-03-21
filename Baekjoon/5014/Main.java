//5014번. 스타트링크
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisit;
    static int f,s,g,u,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = stoi(st.nextToken());
        s = stoi(st.nextToken());
        g = stoi(st.nextToken());
        u = stoi(st.nextToken());
        d = stoi(st.nextToken());
        isVisit = new boolean[f + 1];
        int answer = bfs();
        if(answer == -1) System.out.println("use the stairs");
        else System.out.println(answer);
    }
    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        isVisit[s] = true;
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int q = queue.poll();
                if(q == g) return level; // 목적지 도착 시 누른 버튼 수 return
                if(q + u < f + 1 && !isVisit[q + u]) { //위로 갈 층이 아직 방문하지 않은 층이라면,
                    isVisit[q + u] = true;
                    queue.offer(q + u);
                }
                if(q - d > 0 && !isVisit[q - d]) { //아래로 갈 층이 아직 방문하지 않은 층이라면,
                    isVisit[q - d] = true;
                    queue.offer(q - d);
                }
            }
            level++;
        }
        return -1;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}




















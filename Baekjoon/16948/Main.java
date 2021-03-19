//16948번. 데스 나이트
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int n;
    static boolean[][] isVisit;
    static Node start;
    static Node end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        isVisit = new boolean[n][n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = new Node(stoi(st.nextToken()), stoi(st.nextToken()));
        isVisit[start.r][start.c] = true;
        end = new Node(stoi(st.nextToken()), stoi(st.nextToken()));

        System.out.println(bfs());
    }

    static int dr[] = {-2,-2,0,0,2,2};
    static int dc[] = {-1,1,-2,2,-1,1};
    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (int j = 0; j < 6; j++) {
                    int mr = node.r + dr[j];
                    int mc = node.c + dc[j];
                    if(0 <= mr && mr < n && 0 <= mc && mc < n && !isVisit[mr][mc]) {
                        if(mr == end.r && mc == end.c) {
                            return level;
                        } else {
                            isVisit[mr][mc] = true;
                            queue.offer(new Node(mr,mc));
                        }
                    }
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




















//1600번. 말이 되고픈 원숭이
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static int map[][];
    static boolean isVisit[][][];
    static int r, c, k;
    static class Index {
        int r;
        int c;
        int hCnt;

        public Index(int r, int c, int hCnt) {
            this.r = r;
            this.c = c;
            this.hCnt = hCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = stoi(br.readLine()); // 말의 이동을 할 수 있는 횟수.
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = stoi(st.nextToken());
        r = stoi(st.nextToken());
        map = new int[r][c];
        isVisit = new boolean[r][c][k + 1];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int hr[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int hc[] = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int bfs() {
        if(r==1 && c==1) return 0;
        Queue<Index> queue = new LinkedList<>();
        queue.offer(new Index(0,0,0));
        int move = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            move++;
            for (int i = 0; i < size; i++) {
                Index q = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int mr = q.r + dr[j];
                    int mc = q.c + dc[j];
                    if(mr >= 0 && mr < r && mc >= 0 && mc < c && !isVisit[mr][mc][q.hCnt] && map[mr][mc] != 1) {
                        if(mr == r-1 && mc == c-1) return move;
                        isVisit[mr][mc][q.hCnt] = true;
                        queue.offer(new Index(mr, mc, q.hCnt));
                    }
                }
                for (int j = 0; j < 8; j++) {
                    if(q.hCnt >= k) break;
                    int mr = q.r + hr[j];
                    int mc = q.c + hc[j];
                    if(mr >= 0 && mr < r && mc >= 0 && mc < c && !isVisit[mr][mc][q.hCnt + 1] && map[mr][mc] != 1) {
                        if(mr == r-1 && mc == c-1) return move;
                        isVisit[mr][mc][q.hCnt + 1] = true;
                        queue.offer(new Index(mr, mc, q.hCnt + 1));
                    }
                }
            }
        }
        return -1;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}







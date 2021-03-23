//6593번. 상범 빌딩
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Index {
        int l,r,c;

        public Index(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }
    static char[][][] building;
    static boolean[][][] isVisit;
    static Index start;
    static Index exit;
    static int l,r,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = stoi(st.nextToken());
            r = stoi(st.nextToken());
            c = stoi(st.nextToken());
            if(l == 0 && r == 0 && c == 0) break;
            building = new char[l][r][c];
            isVisit = new boolean[l][r][c];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < c; k++) {
                        building[i][j][k] = s.charAt(k);
                        if(building[i][j][k] == 'S') start = new Index(i,j,k);
                        else if(building[i][j][k] == 'E') exit = new Index(i,j,k);
                    }
                }
                br.readLine();
            }
            isVisit[start.l][start.r][start.c] = true;
            int result = bfs();
            if(result == -1) System.out.println("Trapped!");
            else System.out.println("Escaped in " + result + " minute(s).");
        }
        return;
    }

    static int[] dl = {0,0,0,0,-1,1};
    static int[] dr = {0,0,-1,1,0,0};
    static int[] dc = {-1,1,0,0,0,0};

    private static int bfs() {
        Queue<Index> queue = new LinkedList<>();
        queue.offer(start);
        int minute = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Index q = queue.poll();
                for (int j = 0; j < 6; j++) {
                    int ml = q.l + dl[j];
                    int mr = q.r + dr[j];
                    int mc = q.c + dc[j];
                    if(ml >= 0 && ml < l && mr >= 0 && mr < r && mc >= 0 && mc < c
                            && !isVisit[ml][mr][mc] && building[ml][mr][mc] != '#') {
                        if(ml == exit.l && mr == exit.r && mc == exit.c) {
                            return minute;
                        } else {
                            isVisit[ml][mr][mc] = true;
                            queue.offer(new Index(ml,mr,mc));
                        }
                    }
                }
            }
            minute++;
        }
        return -1;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}




















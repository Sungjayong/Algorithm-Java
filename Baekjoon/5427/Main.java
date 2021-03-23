//5427번. 불
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Index {
        int r,c;

        public Index(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static char[][] building;
    static boolean[][] isVisit;
    static boolean[][] isFireVisit;
    static Index start;
    static Queue<Index> fire;
    static int r,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = stoi(br.readLine());
        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            c = stoi(st.nextToken());
            r = stoi(st.nextToken());
            building = new char[r][c];
            fire = new LinkedList<>();
            isVisit = new boolean[r][c];
            isFireVisit = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                String s = br.readLine();
                for (int j = 0; j < c; j++) {
                    building[i][j] = s.charAt(j);
                    if(building[i][j] == '@') start = new Index(i,j);
                    else if(building[i][j] == '*') fire.offer(new Index(i,j));
                }
            }
            isVisit[start.r][start.c] = true;
            int result = bfs();
            if(result == -1) System.out.println("IMPOSSIBLE");
            else System.out.println(result);

        }
        return;
    }

    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};

    private static int bfs() {
        Queue<Index> queue = new LinkedList<>();
        queue.offer(start);
        int minute = 1;
        while(!queue.isEmpty()) {
            int fireSize = fire.size();
            for (int i = 0; i < fireSize; i++) {
                Index q = fire.poll();
                for (int j = 0; j < 4; j++) {
                    int mr = q.r + dr[j];
                    int mc = q.c + dc[j];
                    if(mr >= 0 && mr < r && mc >= 0 && mc < c && !isFireVisit[mr][mc] && building[mr][mc] != '#' && building[mr][mc] != '*') {
                        isFireVisit[mr][mc] = true;
                        building[mr][mc] = '*';
                        fire.offer(new Index(mr,mc));
                    }
                }
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Index q = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int mr = q.r + dr[j];
                    int mc = q.c + dc[j];
                    if(mr < 0 || mr >= r || mc < 0 || mc >= c) return minute;
                    if(building[mr][mc] == '.' && !isVisit[mr][mc]) {
                        isVisit[mr][mc] = true;
                        queue.offer(new Index(mr,mc));
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




















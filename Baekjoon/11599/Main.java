//11559번. Puyo Puyo
//조건> 하나라도 터트릴 수 있다면,
//1. 4개 이상 모여 있는 뿌요뿌요를 터트린다. => (bfs())
//2. 중력때문에 밑으로 떨어지게 된다. => (dropPuyo(), dropPutyoCol())
import java.io.*;
import java.util.*;

public class Main {
    static class Index {
        int r;
        int c;

        public Index(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int cnt = 0;
        while(bfs()) {
            dropPuyo();
            cnt++;
        }
        System.out.println(cnt);
    }

    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};

    private static boolean bfs() {
        Queue<Index> queue = new LinkedList<>();
        ArrayList<Index> list = new ArrayList<>();
        int puyoPuyo = 0;
        boolean[][] isVisit = new boolean[12][6];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if(map[i][j] == '.') continue;
                queue.offer(new Index(i, j));
                list.add(new Index(i, j));
                isVisit[i][j] = true;
                while(!queue.isEmpty()) {
                    Index q = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int mr = q.r + dr[k];
                        int mc = q.c + dc[k];
                        if(mr>=0 && mr<12 && mc>=0 && mc<6 && map[mr][mc] == map[q.r][q.c] && !isVisit[mr][mc]) {
                            isVisit[mr][mc] = true;
                            list.add(new Index(mr,mc));
                            queue.offer(new Index(mr,mc));
                        }
                    }
                }
                if(list.size() >= 4) {
                    puyoPuyo++;
                    Iterator<Index> itr = list.iterator();
                    while(itr.hasNext()) {
                        Index idx = itr.next();
                        map[idx.r][idx.c] = '.';
                    }
                }
                list.clear();
            }
        }
        if(puyoPuyo > 0) return true;
        return false;
    }

    private static void dropPuyo() {
        for (int j = 0; j < 6; j++) {
            dropPuyoCol(j);
        }
    }

    private static void dropPuyoCol(int j) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 11; i >= 0; i--) {
            if(map[i][j] != '.') sb.append(map[i][j]);
        }
        int len = sb.toString().length();
        for (int i = 0; i < 12 - len; i++) {
            sb.append(".");
        }
        char[] cc = sb.toString().toCharArray();
        int si = 0;
        for (int i = 11; i >= 0; i--) {
            map[i][j] = cc[si++];
        }
    }
}





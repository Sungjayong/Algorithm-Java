//13460번. 구슬 탈출 2
import java.io.*;
import java.util.*;

public class Main {
    public static class Index {
        int r;
        int c;
        public Index(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int n,m;
    static Index red, blue;
    static char[][] map;
    static String inHole = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = cArr[j];
                if(map[i][j] == 'R') {
                    red = new Index(i,j);
                    map[i][j] = '.';
                }
                else if (map[i][j] == 'B') {
                    blue = new Index(i,j);
                    map[i][j] = '.';
                }
            }
        }
        bfs();
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Index> rQueue = new LinkedList<>();
    static Queue<Index> bQueue = new LinkedList<>();
    static int tryCount = 0;

    private static void bfs() {
        rQueue.offer(red);
        bQueue.offer(blue);
        while(!rQueue.isEmpty() && tryCount <= 9) {
            int size = rQueue.size();
            tryCount++;
            for (int i = 0; i < size; i++) {
                Index rq = rQueue.poll();
                Index bq = bQueue.poll();
                //상하좌우로 이동했을 때의 상태 확인
                moveUp(rq,bq);
                moveDown(rq,bq);
                moveLeft(rq,bq);
                moveRight(rq,bq);
            }
        }
        System.out.println(-1);
    }

    private static Index move(Index q, int dir, String color) {
        int mr = q.r;
        int mc = q.c;
        while(true){
            if(mr >= 0 && mr < n && mc >= 0 && mc < m) {
                if(map[mr][mc] == 'O') {
                    inHole = inHole.concat(color);
                    return new Index(-1,-1); //의미없음. 빨리 끝내기 위해
                } else if(map[mr][mc] == '#') { //벽이라면, 직전 위치를 return 시켜 줌.
                    return new Index(mr - dr[dir],mc - dc[dir]);
                }
                mr += dr[dir];
                mc += dc[dir];
            } else {
                return new Index(mr-dr[dir], mc-dc[dir]);
            }
        }
    }

    //어떤 공이 먼저 이동할지 확인.
    //방향에 따라 앞에 있는 공이 먼저 움직여야 함. (같은 인덱스일 경우 신경쓰지 않아도 x)
    private static void moveUp(Index rq, Index bq) {
        int dir = 0;
        Index rmq, bmq;
        if(rq.r > bq.r) {
            bmq = move(bq, dir, "blue");
            if(bmq.r != -1) map[bmq.r][bmq.c] = '#';
            rmq = move(rq, dir, "red");
            if(bmq.r != -1) map[bmq.r][bmq.c] = '.';
        } else {
            rmq = move(rq, dir, "red");
            if(rmq.r != -1) map[rmq.r][rmq.c] = '#';
            bmq = move(bq, dir, "blue");
            if(rmq.r != -1) map[rmq.r][rmq.c] = '.';
        }
        checkBall(rq, bq, rmq, bmq);

    }

    private static void moveDown(Index rq, Index bq) {
        int dir = 1;
        Index rmq, bmq;
        if(rq.r < bq.r) {
            bmq = move(bq, dir, "blue");
            if(bmq.r != -1) map[bmq.r][bmq.c] = '#';
            rmq = move(rq, dir, "red");
            if(bmq.r != -1) map[bmq.r][bmq.c] = '.';
        } else {
            rmq = move(rq, dir, "red");
            if(rmq.r != -1) map[rmq.r][rmq.c] = '#';
            bmq = move(bq, dir, "blue");
            if(rmq.r != -1) map[rmq.r][rmq.c] = '.';
        }
        checkBall(rq, bq, rmq, bmq);
    }

    private static void moveLeft(Index rq, Index bq) {
        int dir = 2;
        Index rmq, bmq;
        if(rq.c > bq.c) {
            bmq = move(bq, dir, "blue");
            if(bmq.r != -1) map[bmq.r][bmq.c] = '#';
            rmq = move(rq, dir, "red");
            if(bmq.r != -1) map[bmq.r][bmq.c] = '.';
        } else {
            rmq = move(rq, dir, "red");
            if(rmq.r != -1) map[rmq.r][rmq.c] = '#';
            bmq = move(bq, dir, "blue");
            if(rmq.r != -1) map[rmq.r][rmq.c] = '.';
        }
        checkBall(rq, bq, rmq, bmq);
    }

    private static void moveRight(Index rq, Index bq) {
        int dir = 3;
        Index rmq, bmq;
        if(rq.c < bq.c) {
            bmq = move(bq, dir, "blue");
            if(bmq.r != -1) map[bmq.r][bmq.c] = '#';
            rmq = move(rq, dir, "red");
            if(bmq.r != -1) map[bmq.r][bmq.c] = '.';
        } else {
            rmq = move(rq, dir, "red");
            if(rmq.r != -1) map[rmq.r][rmq.c] = '#';
            bmq = move(bq, dir, "blue");
            if(rmq.r != -1) map[rmq.r][rmq.c] = '.';
        }
        checkBall(rq, bq, rmq, bmq);
    }

    private static void checkBall(Index rq, Index bq, Index rmq, Index bmq) {
        if (inHole.equals("blue") || inHole.length() > 5) {
            inHole = "";
            return;
        } else if (inHole.equals("red")) {
            System.out.println(tryCount);
            System.exit(0);
        }
        if (!(rmq.r == rq.r && rmq.c == rq.c && bmq.r == bq.r && bmq.c == bq.c)) {
            rQueue.offer(rmq);
            bQueue.offer(bmq);
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
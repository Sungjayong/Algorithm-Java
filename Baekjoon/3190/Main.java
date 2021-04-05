//3190번. 뱀
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Index> deque = new ArrayDeque<>();
        int n = stoi(br.readLine());
        int map[][] = new int[n][n];
        int appleNum = stoi(br.readLine());
        for (int i = 0; i < appleNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ar = stoi(st.nextToken()) - 1;
            int ac = stoi(st.nextToken()) - 1;
            map[ar][ac] = 2;//apple == 2
        }
        int turnNum = stoi(br.readLine());
        String tt[][] = new String[turnNum][2];
        for (int i = 0; i < turnNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tt[i][0] = st.nextToken();
            tt[i][1] = st.nextToken();
        }

        map[0][0] = 1;
        int idx = 0;
        int ttCnt = 0;
        int time = 0;
        int[] dr = {0,-1,0,1};
        int[] dc = {1,0,-1,0};
        deque.offer(new Index(0,0));
        while(true) {
            time++;

            Index q = deque.peekFirst(); //선두로 가던 위치를 꺼냄.
            int mr = q.r + dr[idx];
            int mc = q.c + dc[idx];
            if(mr < 0 || mr >= n || mc < 0 || mc >= n || map[mr][mc] == 1) {
                break;
            } else if(map[mr][mc] == 2) { //사과를 발견했을 경우.
                deque.addFirst(new Index(mr, mc));
                map[mr][mc] = 1;
            } else { //빈공간일 경우.
                deque.addFirst(new Index(mr, mc));
                map[mr][mc] = 1;
                Index pq = deque.removeLast();
                map[pq.r][pq.c] = 0;
            }

            if(ttCnt < turnNum && stoi(tt[ttCnt][0]) == time) { //방향 바꿀 시간이 되면 방향을 바꿔줌.
                if(tt[ttCnt][1].equals("L")) {
                    idx = (idx + 1) % 4;
                } else if(tt[ttCnt][1].equals("D")) {
                    idx = (idx + 3) % 4;
                }
                ttCnt++;
            }
        }
        System.out.println(time);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
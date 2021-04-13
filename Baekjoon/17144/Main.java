//17144번. 미세먼지 안녕!

import java.io.*;
import java.util.*;

public class Main {
    static int r,c;
    static int[][] map;
    static ArrayList<Index> airCleaner = new ArrayList<>();
    static ArrayList<Index> dustList = new ArrayList<>();
    static class Index {
        int r;
        int c;
        int amount;

        public Index(int r, int c, int amount) {
            this.r = r;
            this.c = c;
            this.amount = amount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        r = stoi(st.nextToken());
        c = stoi(st.nextToken());
        int time = stoi(st.nextToken());
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = stoi(st.nextToken());
                if(map[i][j] == -1) {
                    airCleaner.add(new Index(i,j,map[i][j]));
                } else if (map[i][j] >= 5) {
                    dustList.add(new Index(i,j,map[i][j]));
                }
            }
        }
        for (int i = 0; i < time; i++) {
            process();
        }

        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum + 2);
    }

    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    private static void process() {
        //1. 미세먼지 사방 탐색하면서 값 나누기
        for (int i = 0; i < dustList.size(); i++) {
            Index dust = dustList.get(i);
            for (int j = 0; j < 4; j++) {
                int diffusion = dust.amount / 5;
                int mr = dust.r + dr[j];
                int mc = dust.c + dc[j];
                if(mr >= 0 && mr < r && mc >= 0 && mc < c && map[mr][mc] != -1) {
                    map[mr][mc] += diffusion;
                    map[dust.r][dust.c] -= diffusion;
                }
            }
        }
        //2. 바람으로 시계 및 반시계 방향으로 이동시키기
        Index ctrcw = airCleaner.get(0);
        Index cw = airCleaner.get(1);
        windCtrcw(ctrcw);
        windCw(cw);
        dustList.clear();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] >= 5) {
                    dustList.add(new Index(i,j,map[i][j]));
                }
            }
        }
        return;
    }

    private static void windCw(Index cw) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        for (int i = 1; i < c; i++) { //윗변
            queue.offer(map[cw.r][i]);
            map[cw.r][i] = queue.poll();
        }

        for (int i = cw.r + 1; i < r; i++) { //오른쪽 변
            queue.offer(map[i][c-1]);
            map[i][c-1] = queue.poll();
        }

        for (int i = c - 2; i >= 0; i--) { //밑변
            queue.offer(map[r-1][i]);
            map[r-1][i] = queue.poll();
        }

        for (int i = r - 2; i > cw.r; i--) { //왼쪽 변
            queue.offer(map[i][0]);
            map[i][0] = queue.poll();
        }
    }

    private static void windCtrcw(Index ctrcw) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        for (int i = 1; i < c; i++) { // 아랫변
            queue.offer(map[ctrcw.r][i]);
            map[ctrcw.r][i] = queue.poll();
        }

        for (int i = ctrcw.r - 1; i >= 0; i--) { //오른쪽 변
            queue.offer(map[i][c-1]);
            map[i][c-1] = queue.poll();
        }

        for (int i = c - 2; i >= 0 ; i--) { //윗 변
            queue.offer(map[0][i]);
            map[0][i] = queue.poll();
        }

        for (int i = 1; i < ctrcw.r; i++) { // 왼쪽 변
            queue.offer(map[i][0]);
            map[i][0] = queue.poll();
        }
        return;
    }


    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}










//14502번. 연구소
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Index {
        int r,c;

        public Index(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int[][] arr;
    static ArrayList<Index> list = new ArrayList<>();
    static ArrayList<Index> virusList = new ArrayList<>();
    static boolean[][] isVisit;
    static int maxSafetyNum = 0;
    static int r, c;
    static int zeroNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = stoi(st.nextToken());
        c = stoi(st.nextToken());
        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = stoi(st.nextToken());
                if(arr[i][j] == 0) list.add(new Index(i,j));
                else if(arr[i][j] == 2) virusList.add(new Index(i,j));
            }
        }
        zeroNum = list.size() - 3; //3개는 무조건 벽이 될 것이므로.
        comb(0,0);
        System.out.println(maxSafetyNum);
    }

    private static void comb(int cnt, int start) {
        if(cnt == 3) {
            int safetyNum = zeroNum - bfs();
            maxSafetyNum = Math.max(safetyNum, maxSafetyNum);
            return;
        }
        for (int i = start; i < list.size(); i++) {
            Index idx = list.get(i);
            arr[idx.r][idx.c] = 1;
            comb(cnt + 1, i + 1);
            arr[idx.r][idx.c] = 0;
        }
    }

    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};


    private static int bfs() {
        int infectNum = 0;
        Queue<Index> queue = new LinkedList<>();
        for (int i = 0; i < virusList.size(); i++) {
            queue.offer(virusList.get(i));
        }
        isVisit = new boolean[r][c];
        while(!queue.isEmpty()) {
            Index q = queue.poll();
            isVisit[q.r][q.c] = true;
            for (int i = 0; i < 4; i++) {
                int mr = dr[i] + q.r;
                int mc = dc[i] + q.c;
                if(mr >= 0 && mr < r && mc >= 0 && mc < c && !isVisit[mr][mc] && arr[mr][mc] == 0) {
                    infectNum++;
                    isVisit[mr][mc] = true;
                    queue.offer(new Index(mr, mc));
                }
            }
        }
        return infectNum;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
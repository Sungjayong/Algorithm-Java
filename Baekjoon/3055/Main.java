//3055번. 탈출
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static int arr[][];
    static int[] dIdx = new int[2];
    static Queue<int[]> sQueue = new LinkedList<>();
    static Queue<int[]> fQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = stoi(st.nextToken());
        c = stoi(st.nextToken());
        arr= new int[r][c];
        for (int i = 0; i < r; i++) {
            char[] cs = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                arr[i][j] = cs[j];
                if(cs[j] == 'S') sQueue.offer(new int[] {i,j,0});//3번째 parameter : 이동 횟수.
                if(cs[j] == 'D') dIdx = new int[] {i,j};
                if(cs[j] == '*') fQueue.offer(new int[] {i,j});
            }
        }
        int answer = bfs();
        if(answer == -1) System.out.println("KAKTUS");
        else System.out.println(answer);

    }

    private static int bfs() {
        int floodLevel = 0;
        int[] dc = {0,0,-1,1};
        int[] dr = {-1,1,0,0};
        boolean[][] isVisit = new boolean[r][c];
        while(!sQueue.isEmpty()) {
            int[] sq = sQueue.poll();
            if(sq[0] == dIdx[0] && sq[1] == dIdx[1]) return sq[2];
            if(sq[2] == floodLevel) { //이동 횟수가 올랐을 경우 => 범람 범위를 증가시켜줘야 함.
                floodLevel++;
                int ss = fQueue.size();
                for (int n = 0; n < ss; n++) {
                    int[] fq = fQueue.poll();
                    for (int i = 0; i < 4; i++) {
                        if(fq[0] + dr[i] >=0 && fq[0] + dr[i] < r && fq[1] + dc[i] >= 0 && fq[1] + dc[i] < c &&
                                !isVisit[fq[0]+dr[i]][fq[1]+dc[i]] &&
                                arr[fq[0]+dr[i]][fq[1]+dc[i]] == '.') {
                            isVisit[fq[0]+dr[i]][fq[1]+dc[i]] = true;
                            arr[fq[0]+dr[i]][fq[1]+dc[i]] = '*';
                            fQueue.offer(new int[] {fq[0]+dr[i],fq[1]+dc[i]});
                        }
                    }
                }

            }
            for (int i = 0; i < 4; i++) {
                if(sq[0] + dr[i] >=0 && sq[0] + dr[i] < r && sq[1] + dc[i] >= 0 && sq[1] + dc[i] < c &&
                        !isVisit[sq[0]+dr[i]][sq[1]+dc[i]] &&
                        (arr[sq[0]+dr[i]][sq[1]+dc[i]] == '.' || arr[sq[0]+dr[i]][sq[1]+dc[i]] == 'D')) {
                    isVisit[sq[0]+dr[i]][sq[1]+dc[i]] = true;
                    sQueue.offer(new int[] {sq[0]+dr[i],sq[1]+dc[i],sq[2]+1});
                }
            }
        }
        return -1;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}













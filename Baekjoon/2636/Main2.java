//2636번. 치즈
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//공기와 구멍 안을 어떻게 구별해줄것인가.
//시작점부터 bfs => cheeze를 만나면 공기로 변환 & 해당 부분 bfs 진행 stop => 구멍 안은 접근하지 않게 됨!
//모든 치즈가 없어질 때까지 반복.
public class Main2 {
    static int map[][];
    static boolean isProcess[][];
    static int r, c;
    static int cheezeCnt = 0;
    static class Index {
        int r;
        int c;

        public Index(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = stoi(st.nextToken());
        c = stoi(st.nextToken());
        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = stoi(st.nextToken());
                if(map[i][j] == 1) cheezeCnt++;
            }
        }
        int[] result = bfs();

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    private static int[] bfs() {
        Queue<Index> queue = new LinkedList<>();
        int cheezePiece = 0;
        int time = 0;
        while(cheezeCnt != 0) { //모든 치즈가 녹을 때 까지 반복!
            time++;
            isProcess = new boolean[r][c];
            isProcess[0][0] = true;
            queue.offer(new Index(0,0));
            cheezePiece = cheezeCnt;
            while(!queue.isEmpty()) {
                Index q = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int mr = dr[j] + q.r;
                    int mc = dc[j] + q.c;
                    if(mr >= 0 && mr < r && mc >= 0 && mc < c && !isProcess[mr][mc]) {
                        isProcess[mr][mc] = true;
                        if(map[mr][mc] == 0) {
                            queue.offer(new Index(mr,mc));
                        } else if(map[mr][mc] == 1){
                            map[mr][mc] = 0;
                            cheezeCnt--;
                        }
                    }
                }
            }
        }
        return new int[] { time, cheezePiece };
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}







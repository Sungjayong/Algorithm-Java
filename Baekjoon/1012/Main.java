//1012번 : 유기농 배추
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int x; //x축의 길이
    static int y; //y축의 길이
    static int[][] field; //밭 기반 2차원 배열 정의
    static boolean[][] isVisit;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static Queue<int[]> bugIdxQueue = new LinkedList<>();
    static int bugNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            //Input
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            int cabbageNum = Integer.parseInt(st.nextToken());
            bugNum = cabbageNum;
            field = new int[y][x];
            isVisit = new boolean[y][x];
            for (int i = 0; i < cabbageNum; i++) {
                st = new StringTokenizer(br.readLine());
                int bugX = Integer.parseInt(st.nextToken());
                int bugY = Integer.parseInt(st.nextToken());
                field[bugY][bugX] = 1;
                bugIdxQueue.offer(new int[]{bugY, bugX});
            }
            //Processing
            while(!bugIdxQueue.isEmpty()) {
                int a[] = bugIdxQueue.poll();
                bfs(a);
            }

            //Output
            System.out.println(bugNum);
            bugNum = 0;
        }
    }

    public static void bfs(int[] Idx) {
        while (isVisit[Idx[0]][Idx[1]]) {
            if(bugIdxQueue.isEmpty()) return;
            Idx = bugIdxQueue.poll();
        }
        isVisit[Idx[0]][Idx[1]] = true;
        for (int i = 0; i < 4; i++) {
            int surroundX = Idx[1] + dx[i];
            int surroundY = Idx[0] + dy[i];
            if (surroundX >= 0 && surroundX <= x - 1 && surroundY >= 0 && surroundY <= y - 1
                    && !isVisit[surroundY][surroundX]
                    && field[surroundY][surroundX] == 1) {
                bugNum--;
                bfs(new int[]{surroundY, surroundX});
            }
        }
        return;
    }
}




























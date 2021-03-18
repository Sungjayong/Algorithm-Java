//2206번. 벽 부수고 이동하기
import java.io.*;
import java.util.*;

public class Main {
    static int shortestPath = -1; //최단 경로 값.
    static int[][] map;
    static boolean[][][] isVisit;
    static int n;
    static int m;
    static Queue<int[]> bq = new LinkedList<>(); //bfs 사용을 위한 큐.
    public static void main(String[] args) throws IOException {
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        isVisit = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        //Processing
        bq.offer(new int[]{0, 0, 1, 0});//행, 열, 이동 수, 벽뚫 여부
        bfs();
        //Output
        System.out.println(shortestPath);
    }

    private static void bfs() {
        isVisit[0][0][0] = true;
        isVisit[0][0][1] = true;
        while(!bq.isEmpty()) {
            int[] nowIdx = bq.poll();
            if(nowIdx[0] == n - 1 && nowIdx[1] == m - 1) { // 끝 지점 도달 시.
                if (shortestPath == -1 || nowIdx[2] < shortestPath) {
                    shortestPath = nowIdx[2];
                    continue;
                }
            }
            int dx[] = {1,0,-1,0};
            int dy[] = {0,1,0,-1};
            for (int i = 0; i < 4; i++) {
                int nx = nowIdx[1] + dx[i];
                int ny = nowIdx[0] + dy[i];
                if(!(nx >= 0 && nx < m && ny >= 0 && ny < n)) continue;
                if(map[ny][nx] == 1 && !isVisit[ny][nx][1] && nowIdx[3] == 0) { //길을 뚫어야 할 때.
                    isVisit[ny][nx][1] = true;
                    bq.offer(new int[] {ny, nx, nowIdx[2] + 1, nowIdx[3] + 1});
                }
                else if(map[ny][nx] == 0 && !isVisit[ny][nx][nowIdx[3]]) { //정상적인 경로.
                    isVisit[ny][nx][nowIdx[3]] = true;
                    bq.offer(new int[] {ny, nx, nowIdx[2] + 1, nowIdx[3]});
                }
            }
        }
    }
}
























//2468번. 안전 영역
import java.io.*;
import java.util.*;

public class Main {
    static int[][] area;
    static boolean[][] isCheck;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int safeArea = 1;
        area = new int[n][n];
        isCheck = new boolean[n][n];
        int maxAreaHeight = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if(maxAreaHeight < area[i][j]) maxAreaHeight = area[i][j];
            }
        }

        //Process
        for (int h = 1; h <= maxAreaHeight; h++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!isCheck[i][j] && area[i][j] > h) {
                        isCheck[i][j] = true;
                        cnt++;
                        dfs(i, j, h);
                    }
                }
            }
            if(safeArea < cnt) safeArea = cnt;
            //셋 다 초기화.
            cnt = 0;
            isCheck = new boolean[n][n];
        }

        //Output
        System.out.println(safeArea);
    }

    private static void dfs(int r, int c, int height) {
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        for (int i = 0; i < 4; i++) {
            if(r+dy[i] > -1 && r+dy[i] < area.length && c+dx[i] > -1 && c+dx[i] < area.length &&
                    area[r+dy[i]][c+dx[i]] > height && !isCheck[r+dy[i]][c+dx[i]]) {
                isCheck[r+dy[i]][c+dx[i]] = true;
                dfs(r+dy[i], c+dx[i], height);
            }
        }
        return;
    }
}















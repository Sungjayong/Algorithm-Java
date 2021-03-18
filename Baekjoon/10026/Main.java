//10026번. 적록색
import java.io.*;

public class Main {
    static char[][] pic;
    static boolean[][] isCheck;//일반인
    static boolean[][] isBlindCheck;//적록색약
    public static void main(String[] args) throws IOException {
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        pic = new char[n][n];
        isCheck = new boolean[n][n];
        isBlindCheck = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                pic[i][j] = s.charAt(j);
            }
        }
        //Process
        int cnt = 0;
        int bCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!isCheck[i][j]) {
                    isCheck[i][j] = true;
                    cnt++;
                    dfs(i, j, pic[i][j]); }
                if(!isBlindCheck[i][j]) {
                    isBlindCheck[i][j] = true;
                    bCnt++;
                    dfsBlind(i, j, pic[i][j]); }
            }
        }
        //Output
        System.out.println(cnt + " " + bCnt);
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    private static void dfs(int r, int c, char color) {
        for (int i = 0; i < 4; i++) {
            if(r+dy[i] > -1 && r+dy[i] < pic.length && c+dx[i] > -1 && c+dx[i] < pic.length &&
                    pic[r+dy[i]][c+dx[i]] == color && !isCheck[r+dy[i]][c+dx[i]]) {
                isCheck[r+dy[i]][c+dx[i]] = true;
                dfs(r+dy[i], c+dx[i], color);
            }
        }
        return;
    }
    private static void dfsBlind(int r, int c, char color) {
        for (int i = 0; i < 4; i++) {
            if(r+dy[i] > -1 && r+dy[i] < pic.length && c+dx[i] > -1 && c+dx[i] < pic.length
                    && !isBlindCheck[r+dy[i]][c+dx[i]] && (color == pic[r+dy[i]][c+dx[i]]
                    || (color == 'R' && pic[r+dy[i]][c+dx[i]] == 'G')
                    || (color == 'G' && pic[r+dy[i]][c+dx[i]] == 'R'))) {
                isBlindCheck[r + dy[i]][c + dx[i]] = true;
                dfsBlind(r + dy[i], c + dx[i], color);
            }
        }
        return;
    }
}
























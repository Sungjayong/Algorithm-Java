//1987번. 알파벳
import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    static char map[][];
    static int r;
    static int c;
    static int cnt = 1;
    static int maxCnt = 0;
    static boolean[] word = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = stoi(st.nextToken());
        c = stoi(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
        word[map[0][0] - 'A'] = true;
        dfs(0,0);
        System.out.println(maxCnt);
    }

    static int dx[] = {1,0,-1,0};//우하좌상
    static int dy[] = {0,1,0,-1};//우하좌상
    private static void dfs(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int mr = row + dy[i];
            int mc = col + dx[i];
            if(mc >= 0 && mc < c && mr >= 0 && mr < r) {
                if(word[(int)map[mr][mc] - 'A']) {
                    maxCnt = Math.max(maxCnt, cnt);
                    continue;
                }
                word[(int)map[mr][mc] - 'A'] = true;
                cnt++;
                dfs(mr,mc);
            }
        }
        word[(int)map[row][col] - 'A'] = false;
        cnt--;
        return;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
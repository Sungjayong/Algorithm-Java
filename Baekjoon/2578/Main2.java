//2578번. 빙고

import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    static int[][] bingo = new int[5][5];
    static boolean[][] isDraw = new boolean[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = stoi(st.nextToken());
            }
        }
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cnt++;
                int c = stoi(st.nextToken());
                findC(c);
                if(cnt > 10 && validBingo() >= 3) {
                    System.out.println(cnt);
                    System.exit(0);
                }
            }
        }

    }

    private static int validBingo() {
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if(isDraw[i][0] && isDraw[i][1] && isDraw[i][2] && isDraw[i][3] && isDraw[i][4]) cnt++;
            if(isDraw[0][i] && isDraw[1][i] && isDraw[2][i] && isDraw[3][i] && isDraw[4][i]) cnt++;
        }
        if(isDraw[0][0] && isDraw[1][1] && isDraw[2][2] && isDraw[3][3] && isDraw[4][4]) cnt++;
        if(isDraw[0][4] && isDraw[1][3] && isDraw[2][2] && isDraw[3][1] && isDraw[4][0]) cnt++;
        return cnt;
    }

    private static void findC(int c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(bingo[i][j] == c) {
                    isDraw[i][j] = true;
                }
            }
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
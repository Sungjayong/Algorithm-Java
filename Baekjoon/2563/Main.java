//2563번 : 색종이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int paperNum = Integer.parseInt(br.readLine());
        int[][] paperIdx = new int [paperNum][2];
        boolean[][] isColored = new boolean[100][100];
        int area = 0; //넓
        for (int i = 0; i < paperNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            paperIdx[i][0] = Integer.parseInt(st.nextToken());
            paperIdx[i][1] = Integer.parseInt(st.nextToken());
            for (int j = paperIdx[i][1]; j < 10 + paperIdx[i][1]; j++) {
                for (int k = paperIdx[i][0]; k < paperIdx[i][0] + 10; k++) {
                    if(isColored[j][k]) continue;//이미 칠해졌으면 넘어감.
                    area++; //안 칠해졌으면 넓이 값 +1씩 계속해줌.
                    isColored[j][k] = true;
                }
            }
        }
        System.out.println(area);
    }
}
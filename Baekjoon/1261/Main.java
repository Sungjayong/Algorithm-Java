//1261번. 알고스팟
import java.io.*;
import java.util.Arrays;
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
    static int[][] dp;
    static int r,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = stoi(st.nextToken());
        r = stoi(st.nextToken());
        arr = new int[r][c];
        dp = new int[r][c];
        for (int[] i : dp) {
            Arrays.fill(i,10000);
        }
        for (int i = 0; i < r; i++) {
            char[] cc = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                arr[i][j] = cc[j] - '0';
            }
        }
        System.out.println(bfs());
    }

    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};


    private static int bfs() {
        Queue<Index> queue = new LinkedList<>();
        queue.offer(new Index(0,0));
        dp[0][0] = 0;
        while(!queue.isEmpty()){
            Index q = queue.poll();
            for (int i = 0; i < 4; i++) {
                int mr = dr[i] + q.r;
                int mc = dc[i] + q.c;
                if(mr >= 0 && mr < r && mc >= 0 && mc < c) {
                    if(dp[mr][mc] > dp[q.r][q.c] + arr[mr][mc]) {
                        dp[mr][mc] = dp[q.r][q.c] + arr[mr][mc];
                        queue.offer(new Index(mr,mc));
                    }
                }
            }
        }
        return dp[r-1][c-1];
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
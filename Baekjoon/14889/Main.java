//14889번. 스타트와 링크
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static boolean[] isStart;
    static int[][] map;
    static int minGap = Integer.MAX_VALUE;
    static int[] select;
    static int[] notSelect;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        m = n / 2;
        map = new int[n][n];
        isStart = new boolean[n];
        select = new int[n/2];
        notSelect = new int[n/2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }
        comb(0,0);
        System.out.println(minGap);
    }

    private static void comb(int cnt, int start) {
        if(cnt == m) {
            int s = 0;
            int ns = 0;
            for (int i = 0; i < n; i++) {
                if(isStart[i]) select[s++] = i;
                else notSelect[ns++] = i;
            }
            calc();
        }

        for (int i = start; i < n; i++) {
            isStart[i] = true;
            comb(cnt + 1, i + 1);
            isStart[i] = false;
        }
    }

    private static void calc() {
        int selectSum = 0;
        int notSelectSum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                selectSum += map[select[i]][select[j]];
                notSelectSum += map[notSelect[i]][notSelect[j]];
            }
        }
        minGap = Math.min(minGap,Math.abs(selectSum - notSelectSum));
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}




















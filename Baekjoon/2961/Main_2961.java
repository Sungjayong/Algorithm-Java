//2961번. 도영이가 만든 맛있는 음식
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_SIZE = 99999999;
    static int[][] cook;
    static int minDiff = MAX_SIZE;
    public static void main(String[] args) throws IOException {
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cook = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cook[i][0] = Integer.parseInt(st.nextToken());
            cook[i][1] = Integer.parseInt(st.nextToken());
        }
        //Process
        subset(0,1,0);
        //Output
        System.out.println(minDiff);
    }

    private static void subset(int cnt, int sour, int bitter) {
        if(cnt == cook.length) {
            if(sour == 1 && bitter == 0) return; //공집합일 때.
            if (Math.abs(bitter - sour) < minDiff) {
                minDiff = Math.abs(bitter - sour);
            }
            return;
        }
        subset(cnt + 1, sour * cook[cnt][0], bitter + cook[cnt][1]);
        subset(cnt + 1, sour, bitter);
    }
}
























//12865번. 평범한 배
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int k = stoi(st.nextToken());
        int[] weights = new int[n+1];
        int[] profits = new int[n+1];
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = stoi(st.nextToken());
            profits[i] = stoi(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= k; w++) {
                if(weights[i] <= w) {
                    dp[i][w] = Math.max(dp[i-1][w-weights[i]] + profits[i], dp[i-1][w]);
                } else dp[i][w] = dp[i-1][w];
            }
        }
        System.out.println(dp[n][k]);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
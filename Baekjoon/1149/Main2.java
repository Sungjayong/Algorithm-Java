//1149번. RGB 거리
import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = stoi(st.nextToken());
            arr[i][1] = stoi(st.nextToken());
            arr[i][2] = stoi(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            arr[i][0] += Math.min(arr[i-1][1], arr[i-1][2]);
            arr[i][1] += Math.min(arr[i-1][0], arr[i-1][2]);
            arr[i][2] += Math.min(arr[i-1][0], arr[i-1][1]);
        }
        int result = Math.min(arr[n][0], arr[n][1]);
        result = Math.min(arr[n][2], result);
        System.out.println(result);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
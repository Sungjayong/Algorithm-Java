//1932번. 정수 삼각형
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int height = stoi(br.readLine());
        int[][] arr = new int[height][height];
        for (int i = 0; i < height; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tokenNum = st.countTokens();
            for (int j = 0; j < tokenNum; j++) {
                arr[i][j] = stoi(st.nextToken());
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < i + 1; j++) {
                if(i > 0 && j > 0) arr[i][j] += Math.max(arr[i-1][j], arr[i-1][j-1]);
                else if(i > 0 && j == 0) {
                    arr[i][j] += arr[i-1][j];
                }
            }
        }
        Arrays.sort(arr[height - 1]);
        System.out.println(arr[height - 1][height - 1]);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
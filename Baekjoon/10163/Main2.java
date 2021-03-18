//10163번. 색종이
import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = stoi(br.readLine());
        int arr[][] = new int[101][101];
        int size[] = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());
            int dx = stoi(st.nextToken());
            int dy = stoi(st.nextToken());
            for (int j = y; j < y + dy; j++) {
                for (int k = x; k < x + dx; k++) {
                    arr[j][k] = i;
                }
            }
        }
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                size[arr[i][j]]++;
            }
        }
        for (int i = 1; i <= num; i++) {
            System.out.println(size[i]);
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
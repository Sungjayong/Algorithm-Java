//9205번. 맥주 마시면서 걸어가기
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = stoi(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int n = stoi(br.readLine());
            int[][] arr = new int[n+2][n+2];
            int[][] idx = new int[n+2][2];
            for (int i = 0; i < n+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                idx[i][0] = stoi(st.nextToken());
                idx[i][1] = stoi(st.nextToken());
            }
            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < n + 2; j++) {
                    arr[i][j] = Math.abs(idx[i][0] - idx[j][0]) + Math.abs(idx[i][1] - idx[j][1]);
                    if(arr[i][j] <= 1000) arr[i][j] = 0;
                }
            }

            for(int k=0; k<n+2; ++k) {
                for(int i=0; i<n+2; ++i) {
                    if(i==k) continue; // 출발지와 경유지가 같다면 다음 출발지
                    for(int j=0; j<n+2; ++j) {
                        if(i==j || k==j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
                        if(arr[i][j] > arr[i][k] + arr[k][j]) {
                            arr[i][j] = arr[i][k] + arr[k][j];
                        }
                    }
                }
            }
            if(arr[0][n+1] == 0) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
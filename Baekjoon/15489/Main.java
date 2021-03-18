import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input =br.readLine();
        String rcw[] = input.split(" ");
        int r = Integer.parseInt(rcw[0]) - 1;
        int c = Integer.parseInt(rcw[1]) - 1;
        int w = Integer.parseInt(rcw[2]);
        int[][] arr = new int[30][30];
        int minus = 0;

        for (int i = 0; i < 30; i++) {
            for(int j = 0; j < 30; j++) {
                if(i == 0 || j == 0) {
                    arr[i][j] = 1;
                }
                else arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }

        int sum = 0;
        for (int i = r - c; i < r + w; i++) {
            for (int j = c; j < c + w - minus; j++) {
                sum += arr[i][j];
            }
            minus++;
        }
        System.out.println(sum);
        br.close();
        return;
    }
}

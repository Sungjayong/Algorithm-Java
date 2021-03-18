//16113번. 시그널
import java.io.*;

public class Main2 {
    static int[][] signal;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        signal = new int[5][n/5];
        sb = new StringBuilder("");
        char[] ch = br.readLine().toCharArray();
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n / 5; j++) {
                signal[i][j] = ch[cnt++] == '#' ? 1 : 0;
            }
        }
        decode();
        System.out.println(sb.toString());
    }

    private static void decode() {
        int idx = 0;
        while (idx < signal[0].length) {
            if (sumCol(idx) == 15) { // 0, 1, 6, or 8
                if (idx + 1 == signal[0].length || sumCol(idx + 1) == 0) {
                    sb.append(1);
                    idx += 1;
                    continue;
                }
                else if (sumCol(idx + 1) == 6) sb.append(0);
                else if(sumCol(idx + 2) == 13) sb.append(6);
                else if (sumCol(idx + 2) == 15) sb.append(8);
            }
            else if(sumCol(idx) == 13) sb.append(2);
            else if(sumCol(idx) == 9) sb.append(3);
            else if(sumCol(idx) == 6) sb.append(4);
            else if(sumCol(idx) == 11) { // 5 or 9
                if(sumCol(idx + 2) == 15) sb.append(9);
                else sb.append(5);
            }
            else if(sumCol(idx) == 1) sb.append(7);
            else if(sumCol(idx) == 0) { // 빈 줄이면
                idx += 1;
                continue;
            }
            idx += 3;
        }
    }

    private static int sumCol(int i){
        int sum = 0;
        if (signal[0][i] == 1) sum += 1;
        if (signal[1][i] == 1) sum += 2;
        if (signal[2][i] == 1) sum += 3;
        if (signal[3][i] == 1) sum += 4;
        if (signal[4][i] == 1) sum += 5;
        return sum;
    }

    private static int stoi (String s){
        return Integer.parseInt(s);
    }
}
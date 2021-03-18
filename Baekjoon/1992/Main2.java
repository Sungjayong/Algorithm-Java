//1992번. 쿼드트리.
import java.io.*;

public class Main2 {
    static StringBuilder sb = new StringBuilder("");
    static int arr[][];
    public static void main(String[] args) throws IOException {
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = stoi(br.readLine());
        arr = new int[num][num];
        for (int i = 0; i < num; i++) {
            String s = br.readLine();
            for (int j = 0; j < num; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        sol(num,0,0);
        System.out.println(sb.toString());
    }

    private static void sol(int num, int x, int y) {
        if(isCompress(num, x, y)) {
            sb.append(arr[y][x]);
        }else {
            sb.append("(");
            sol(num/2, x, y);
            sol(num/2, x + num/2, y);
            sol(num/2, x, y + num/2);
            sol(num/2, x + num/2, y + num/2);
            sb.append(")");
        }
    }

    private static boolean isCompress(int num, int x, int y) {
        for (int i = y; i < y + num; i++) {
            for (int j = x; j < x + num; j++) {
                if(arr[y][x] != arr[i][j]) return false;
            }
        }
        return true;
    }
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
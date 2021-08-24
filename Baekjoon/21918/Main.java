//21918번. 전구
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] bolbs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        bolbs = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if(stoi(st.nextToken()) == 1) bolbs[i] = true;
            else bolbs[i] = false;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = stoi(st.nextToken());
            switch (command){
                case 1:
                    oneFunc(stoi(st.nextToken()) - 1, stoi(st.nextToken()));
                    break;
                case 2:
                    twoFunc(stoi(st.nextToken()) - 1, stoi(st.nextToken()) - 1);
                    break;
                case 3:
                    onAndOff(false, stoi(st.nextToken()) - 1, stoi(st.nextToken()) - 1);
                    break;
                case 4:
                    onAndOff(true, stoi(st.nextToken()) - 1, stoi(st.nextToken()) - 1);
                    break;
            }
//            System.out.println(Arrays.toString(bolbs));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(bolbs[i]) sb.append("1 ");
            else sb.append("0 ");
        }
        System.out.println(sb.toString());
    }

    private static void oneFunc(int idx, int x) {
        if(x == 1) bolbs[idx] = true;
        else bolbs[idx] = false;
    }

    private static void twoFunc(int l, int r) {
        for (int i = l; i <= r; i++) {
            bolbs[i] = !bolbs[i];
        }
    }

    private static void onAndOff(boolean b, int l, int r) {
        for (int i = l; i <= r; i++) {
            bolbs[i] = b;
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
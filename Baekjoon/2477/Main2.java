//2477번. 참외밭
import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int arr[][] = new int[6][2];
        int isSelect[] = new int[5];
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            isSelect[a]++;
        }
        int bigSquare = 1;
        int sum = 0;
        int idx = 0;
        int big[] = new int[2];//긴 변 두개.
        for (int i = 1; i <= 4; i++) {
            if(isSelect[i] == 1) big[idx++] = i;
        }
        int before = 0;
        int now = 0;
        for (int i = 0; i < 6; i++) {
            if(arr[i][0] == big[0]) bigSquare *= arr[i][1];
            if(arr[i][0] == big[1]) bigSquare *= arr[i][1];
            now = arr[i][1];
            sum += now * before;
            before = now;
        }
        now = arr[0][1];
        sum += before * now;

        System.out.println(n * (sum - 2 * bigSquare));
        //bigSquare - (3 * bigSquare - sum)
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
//2798번 : 블랙잭
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n; // 카드의 갯수
    static int m; // 한도합
    static int min = 300000;
    static int[] pick = new int[3];
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        combination(0, 0);
        System.out.println(m - min);
    }

    static private void combination(int cnt, int start) {
        if(cnt == 3) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += pick[i];
            }
            if(sum <= m && m-sum <= min){ // m의 값보다 작으며, 가장 차이가 나지않으면!
                min = m - sum;
            }
            return;
        }
        for (int i = start; i < n; i++) {
            pick[cnt] = arr[i];
            combination(cnt + 1, i + 1);
            if(min == 0) return;
        }
    }

}

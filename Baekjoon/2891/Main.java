//2891번. 카약과 강풍
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int teamSize = stoi(st.nextToken());
        int lackNum = stoi(st.nextToken());
        int plentyNum = stoi(st.nextToken());
        int pCnt = 0;
        int[] arr = new int[teamSize];
        Arrays.fill(arr, 1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < lackNum; i++) {
            arr[stoi(st.nextToken()) - 1]--;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < plentyNum; i++) {
            arr[stoi(st.nextToken()) - 1]++;
        }

        //Process
        for (int i = 0; i < teamSize; i++) {
            if(arr[i] == 0) {
                if(i - 1 >= 0 && arr[i - 1] == 2) {
                    arr[i - 1]--;
                    arr[i]++;
                }
                else if(i + 1 < teamSize && arr[i + 1] == 2) {
                    arr[i + 1]--;
                    arr[i]++;
                }
                else pCnt++;
            }
        }
        System.out.println(pCnt);
    }
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
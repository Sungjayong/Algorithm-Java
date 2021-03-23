//2748번. 피보나치 수 2
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        long arr[] = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[n]);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}




















//9461번. 파도반 수열
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = stoi(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int n = stoi(br.readLine());
            System.out.println(solve(n));
        }
    }

    private static long solve(int n) {
        long[] arr = new long[n+1];
        if(n >= 1) arr[1] = 1;
        if(n >= 2) arr[2] = 1;
        if(n >= 3) arr[3] = 1;
        for (int i = 4; i <= n; i++) {
            arr[i] = arr[i-2] + arr[i-3];
        }
        return arr[n];
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
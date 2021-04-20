//11727번. 2*n 타일링 2
//a[n] = a[n-1] + 2*a[n-2]
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        int[] arr = new int[n+1];
        if(n >= 1) arr[1] = 1;
        if(n >= 2) arr[2] = 3;
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i-1] + 2 * arr[i-2]) % 10007;
        }
        return arr[n];
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
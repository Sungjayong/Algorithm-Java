//11399번. ATM
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st =new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = stoi(st.nextToken());
        }
        Arrays.sort(arr);
        int m = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (m + arr[i]);
            m += arr[i];
        }
        System.out.println(sum);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
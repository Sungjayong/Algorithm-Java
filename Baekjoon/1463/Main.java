////1463번. 1로 만들기
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int[] arr = new int[n+1];
        arr[1] = 0;
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> list = new ArrayList();
            if(i % 3 == 0) list.add(arr[i/3] + 1);
            if(i % 2 == 0) list.add(arr[i/2] + 1);
            list.add(arr[i-1] + 1);
            arr[i] = Collections.min(list);
        }
        System.out.println(arr[n]);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}

















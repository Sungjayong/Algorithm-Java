//2605번. 줄 세우기

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2 {
    static LinkedList<Integer> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= num; i++) {
            int a = stoi(st.nextToken());
            list.add(i - 1 - a, i);
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < num; i++) {
            sb.append(list.get(i) + " ");
        }
        System.out.println(sb.toString());
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
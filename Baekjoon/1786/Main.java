//1786번. 찾기
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] t = br.readLine().toCharArray();
        char[] p = br.readLine().toCharArray();
        int tLength = t.length, pLength = p.length;
        int[] fail = new int[pLength];
        for (int i = 1, j = 0; i < pLength; i++) {
            while(j > 0 && p[i] != p[j]) {
                j = fail[j - 1];
            }
            if(p[i] == p[j]) {
                fail[i] = ++j;
            }
        }

        int cnt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        // i : 텍스트 포인터 , j: 패턴 포인터
        for (int i = 0, j = 0; i < tLength; i++) {
            while(j > 0 && t[i] != p[j])
                j = fail[j - 1];
            if(t[i] == p[j]) {
                if(j == pLength - 1) {
                    cnt++;
                    list.add((i+1) - pLength + 1);
                    j = fail[j];
                } else {
                    j++;
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        sb.append(cnt + "\n");
        if(cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                sb.append(list.get(i) + " ");
            }
        }
        System.out.println(sb.toString());
    }
}




















//16922번. 로마 숫자 만들기
import java.io.*;
import java.util.HashSet;

public class Main {
    static int n;
    static char[] cc = {'I', 'V', 'X', 'L'};
    static HashSet<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder("");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        comb(0,0);
        System.out.println(set.size());
    }

    private static void comb(int cnt, int start) {
        if(cnt == n) {
            int result = solve(sb.toString());
            set.add(result);
            return;
        }
        for (int i = start; i < 4; i++) {
            sb.append(cc[i]);
            comb(cnt + 1, i);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static int solve(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'I': sum += 1; break;
                case 'V': sum += 5; break;
                case 'X': sum += 10; break;
                case 'L': sum += 50; break;
            }
        }
        return sum;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
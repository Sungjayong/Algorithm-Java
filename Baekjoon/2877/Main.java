//2877번. 4와 7
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine()) - 1;
        int k = 0;
        while(true) {
            int sub = (int) Math.pow(2, k + 1);
            if (n >= sub) n -= sub;
            else break;
            k++;
        }
//        System.out.println(k);
        String s2 = Integer.toBinaryString(n);
//        System.out.println(s2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            if(s2.charAt(i) == '0') sb.append('4');
            else if(s2.charAt(i) == '1') sb.append('7');
        }
        for (int i = 0; i < k - s2.length() + 1; i++) {
            sb.insert(0, 4);
        }
        System.out.println(sb.toString());
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
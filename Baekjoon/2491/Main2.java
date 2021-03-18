//2491번. 수열
import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxLength = 0;
        int lenAscend = 1;
        int lenDescend = 1;
        String n = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int before = stoi(st.nextToken());
        int now;
        for (int i = 0; i < stoi(n) - 1; i++) {
            now = stoi(st.nextToken());
            if(now >= before) { //오름차순
                lenAscend++;
            } else {
                maxLength = Math.max(lenAscend, maxLength);
                lenAscend = 1;
            }

            if(now <= before) { //내림차순
                lenDescend++;
            } else {
                maxLength = Math.max(lenDescend, maxLength);
                lenDescend = 1;
            }
            before = now;
        }
        maxLength = Math.max(maxLength,lenAscend);
        maxLength = Math.max(maxLength,lenDescend);

        System.out.println(maxLength);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
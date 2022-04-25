//10025번. 게으른 백곰
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    final static int POUND_SIZE = 1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int k = stoi(st.nextToken());
        int[] pound = new int[POUND_SIZE];
        int maxIceNum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int iceNum = stoi(st.nextToken());
            int idx = stoi(st.nextToken());
            pound[idx] = iceNum;
        }
        int windowSize = Math.min(2 * k + 1, POUND_SIZE);

        for (int i = 0; i < windowSize; i++) {
            maxIceNum += pound[i];
        }

        int movedIceNum = maxIceNum;
        for (int i = 0; i < POUND_SIZE - windowSize; i++) {
            movedIceNum = movedIceNum - pound[i] + pound[i + windowSize];
            if(movedIceNum > maxIceNum) {
                maxIceNum = movedIceNum;
            }
        }
        System.out.println(maxIceNum);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
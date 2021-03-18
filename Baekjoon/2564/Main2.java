//2564번. 경비원
import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int x =stoi(st.nextToken());
        int y =stoi(st.nextToken());
        int num = stoi(br.readLine());
        int store[][] = new int[num][2];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            store[i][0] = stoi(st.nextToken()); //상하좌우 위치.
            store[i][1] = stoi(st.nextToken()); //이동값
        }
        st = new StringTokenizer(br.readLine());
        int comPart = stoi(st.nextToken());
        int comIdx = stoi(st.nextToken());

        int sum = 0;
        for (int i = 0; i < num; i++) {
            int cycle = Cycle(comPart, comIdx, store[i][0], store[i][1], x, y);
            sum += Math.min(cycle, 2*(x+y) - cycle);
        }
        System.out.println(sum);
    }

    private static int Cycle(int comPart, int comIdx, int stoPart, int stoIdx, int x, int y) {
        int sum = 0;
        while(true) {
            if(comPart == stoPart) {
                return sum + Math.abs(comIdx - stoIdx);
            } else if(comPart == 1) {
                comPart = 4;
                sum += x - comIdx;
                comIdx = 0;
            } else if(comPart == 4) {
                comPart = 2;
                sum += y - comIdx;
                comIdx = x;
            } else if(comPart == 2) {
                comPart = 3;
                sum += comIdx;
                comIdx = y;
            } else if(comPart == 3) {
                comPart = 1;
                sum += comIdx;
                comIdx = 0;
            }
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
//17103번. 골드바흐 파티션
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = stoi(br.readLine());
        int[] question = new int[testCase];
        int maxQ = 0;
        for (int t = 0; t < testCase; t++) {
            question[t] = stoi(br.readLine());
            maxQ = Math.max(maxQ, question[t]);
        }
        //에라토스테네스의 체 생성 시작!
        //1. 배열 생성
        int[] ll = new int[maxQ + 1];
        for (int i = 2; i <= maxQ; i++) {
            ll[i] = i;
        }
        //2. 2부터 시작해서 특정 수의 배수에 해당하는 수 삭제.
        for (int i = 2; i <= maxQ; i++) {
            if(ll[i] == 0) continue;
            for(int j = 2 * i; j <= maxQ; j += i) {
                ll[j] = 0;
            }
        }

        //3. 소수들에 대해 만들려는 수 - 해당 소수 인 수가 소수일 경우 cnt++
        for (int t = 0; t < testCase; t++) {
            int val = question[t];
            int cnt = 0;
            for (int i = 2; i <= val/2; i++) {
                if(ll[i] == 0) continue;
                if(ll[val-i] != 0) cnt++;
            }
            System.out.println(cnt);
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
//2839번. 설탕 배달
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int bagFiveNum = 0;
        int bagNum = 0;
        while(n != 0){
            if(n >= 5) { bagNum++; bagFiveNum++; n -= 5; } // 5kg 주머니 사용
            else if(n == 3) { bagNum++; n -= 3; } // 3kg 주머니 사용
            else { //5kg 주머니를 3kg 주머니로 변경. => (+5 -3)
                if(bagFiveNum >= 1) {n += 2; bagFiveNum--;} //변경할 5kg 주머니가 있어야 함.
                else { bagNum = -1; break; } //변경할 주머니가 없으면 -1 반환.
            }
        }
        System.out.println(bagNum);
    }
}
























//2036번. 수열의 점수
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        ArrayList<Long> plus = new ArrayList<>();
        ArrayList<Long> minus = new ArrayList<>();
        boolean isZero = false;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long a = stoi(br.readLine());
            if(a > 0) plus.add(a);
            else if(a < 0) minus.add(a);
            else if(a == 0) isZero = true;
        }

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);
        while(plus.size() > 0 && plus.get(plus.size() - 1) == 1) { //1이 존재하면 미리 1씩 더해주고 삭제.
            sum += 1;
            plus.remove(plus.size() - 1);
        }
        if(isZero && minus.size()%2 == 1) minus.remove(minus.size() - 1);
        //0이 있고, 음수가 홀수 개 있는 경우 => 제일 절댓값이 작은 음수값을 리스트에서 제거한다.
        //System.out.println(plus);
        //System.out.println(minus);
        for (int i = 0; i < plus.size(); i+=2) {
            if((i + 1) != plus.size()) sum += plus.get(i) * plus.get(i + 1);
            else sum += plus.get(i);
        }
        for (int i = 0; i < minus.size(); i+=2) {
            if((i + 1) != minus.size()) sum += minus.get(i) * minus.get(i + 1);
            else sum += minus.get(i);
        }
        System.out.println(sum);

    }
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
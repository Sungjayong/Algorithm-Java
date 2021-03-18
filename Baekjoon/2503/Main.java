//2503번 : 숫자 야구
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        LinkedList<String> survivor = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if(i == j || j == k || i == k) continue;
                    survivor.add(arr[i] + arr[j] + arr[k]); //set 생성.
                }
            }
        }
        int n = Integer.parseInt(br.readLine());
        for (int t = 0; t < n; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int strikeCount = Integer.parseInt(st.nextToken());
            int ballCount = Integer.parseInt(st.nextToken());
            Iterator<String> it = survivor.iterator(); // 반복자 생성.
            while(it.hasNext()) {
                String sur = it.next();
                int hundreds = s.charAt(0) == sur.charAt(0) ? 1 : 0;
                int tens = s.charAt(1) == sur.charAt(1) ? 1 : 0;
                int ones = s.charAt(2) == sur.charAt(2) ? 1 : 0;
                int hundredb = s.contains(Character.toString(sur.charAt(0))) && s.charAt(0) != sur.charAt(0) ? 1 : 0;
                int tenb = s.contains(Character.toString(sur.charAt(1))) && s.charAt(1) != sur.charAt(1) ? 1 : 0;
                int oneb = s.contains(Character.toString(sur.charAt(2))) && s.charAt(2) != sur.charAt(2) ? 1 : 0;
                if(strikeCount != hundreds + tens + ones) {
                    it.remove(); //바로 리스트 제거 불가능 ㅠ
                    continue;
                }
                if(ballCount != hundredb + tenb + oneb) {
                    it.remove();
                    continue;
                }
            }
            if(survivor.size() == 1) {
                break;
            }
        }
        System.out.println(survivor.size());
    }
}
//문제를 잘 읽읍시다.. 1개남으면 게임 바로 끝내줘야 되고 숫자가 중복이 안되네요 하하하...
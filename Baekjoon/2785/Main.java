//2785번. 체인
import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            list.add(stoi(st.nextToken()));
        }
        Collections.sort(list); //3,4,5,7,9
        while(list.size() != 1) {
            cnt++;
            list.set(0,list.getFirst() - 1);
            if(list.getFirst() == 0) {
                list.removeFirst();
                if(list.size() == 1) break;
            }
            //int m = list.getLast(); //가장 많은 고리의 길이
            list.removeLast();//가장 많은 2 고리를 합쳐 줌.
            //list.set(list.size()-1, list.getLast() + m);
            // 하지만 여기서 연결된 체인 길이는 중요 사안이 아니므로 연산하지 않음.
        }
        System.out.println(cnt);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}













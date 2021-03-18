//1911번. 흙길 보수하기
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int l = stoi(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[] {stoi(st.nextToken()),stoi(st.nextToken())});
        }
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);
        int okLength = 0;
        int plankNum = 0;
        for (int i = 0; i < n; i++) {
            int start = Math.max(list.get(i)[0], okLength);
            int end = list.get(i)[1];
            int cnt = (int) Math.ceil((end - start) / (double)l);
            plankNum += cnt;
            start += cnt * l;
//            while(start < end) {
//                plankNum++;
//                start += l;
//            }
            okLength = start;
        }
        System.out.println(plankNum);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}






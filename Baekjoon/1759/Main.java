//1759번. 암호 만들기
import org.w3c.dom.NodeList;

import java.io.*;
import java.util.*;

public class Main {
    static int l;
    static int c;
    static char[] list;
    static char[] alphabet;
    static ArrayList<String> answer = new ArrayList<>();
    static String vowArr = "aeiou";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = stoi(st.nextToken());
        c = stoi(st.nextToken());
        list = new char[c];
        alphabet = new char[l];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            list[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(list);

        for (int i = 2; i < l; i++) {
            solve(i, l - i, 0, 0);
        }
        Collections.sort(answer);
        Iterator<String> it = answer.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private static void solve(int con, int vow, int cnt, int start) {
        if(cnt == l) {
//            System.out.println(String.valueOf(alphabet));
            answer.add(String.valueOf(alphabet));
            return;
        }
        for (int i = start; i < c; i++) {
            if(vowArr.contains(String.valueOf(list[i]))) {//모음일 때.
                if(vow > 0){
                    alphabet[cnt] = list[i];
                    solve(con, vow - 1, cnt + 1, i + 1);
                } else {
                }
            } else {//자음일 때.
                if(con > 0) {
                    alphabet[cnt] = list[i];
                    solve(con - 1, vow, cnt + 1, i + 1);
                }
            }
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}




















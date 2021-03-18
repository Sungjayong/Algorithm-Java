//18428번. 감시 피하기
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Space {
        int r, c;

        public Space(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static char[][] map;
    static int size;
    static int n;
    static ArrayList<Space> spaces = new ArrayList<>();
    static ArrayList<Space> teachers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if(map[i][j] == 'X') spaces.add(new Space(i,j));
                else if(map[i][j] == 'T') teachers.add(new Space(i,j));
            }
        }
        size = spaces.size();
        comb(0,0);
        System.out.println("NO");
    }

    private static void comb(int cnt, int start) {
        if(cnt == 3) {
            //감시를 모두 피할 수 있는 지 확인.
            if(calc()) {
                System.out.println("YES");
                System.exit(0);
            } else return;
        }

        for (int i = start; i < size; i++) {
            Space s = spaces.get(i);
            map[s.r][s.c] = 'B';
            comb(cnt + 1, i + 1);
            map[s.r][s.c] = 'X';
        }
    }

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    private static boolean calc() {
        for (int i = 0; i < teachers.size(); i++) {
            Space t = teachers.get(i);
            for (int j = 0; j < 4; j++) {
                int mr = t.r + dr[j];
                int mc = t.c + dc[j];
                while(0 <= mr && mr < n && 0 <= mc && mc < n) {
                    if(map[mr][mc] == 'S') return false;
                    else if(map[mr][mc] == 'B') break;
                    mr += dr[j];
                    mc += dc[j];
                }
            }
        }
        return true;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}




















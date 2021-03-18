//2583번. 영역 구하기.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] isVisit;
    static int whiteSpace = 0;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); //세로 길이
        int n = Integer.parseInt(st.nextToken()); //가로 길이
        int k = Integer.parseInt(st.nextToken()); //직사각형 갯수
        isVisit = new boolean[m][n];
        for (int a = 0; a < k; a++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int fx = Integer.parseInt(st.nextToken());
            int fy = Integer.parseInt(st.nextToken());
            for (int i = sy; i < fy; i++) {
                for (int j = sx; j < fx; j++) {
                    isVisit[i][j] = true;
                }
            }
        }
        //Process
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!isVisit[i][j]) {
                    isVisit[i][j] = true;
                    dfs(i, j); //사방탐색하면서 dfs.
                    list.add(whiteSpace);
                    whiteSpace = 0;
                }
            }
        }
        //Output
        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+ " ");
        }
    }

    private static void dfs(int y, int x) {
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        whiteSpace++;
        for (int i = 0; i < 4; i++) {
            if(y + dy[i] >= 0 && y + dy[i] < isVisit.length && x + dx[i] >= 0 && x + dx[i] < isVisit[0].length
                    && !isVisit[y+dy[i]][x+dx[i]]) {
                isVisit[y+dy[i]][x+dx[i]] = true;
                dfs(y+dy[i], x+dx[i]);
            }
        }
        return;
    }
}
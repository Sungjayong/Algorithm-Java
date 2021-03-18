//2667번. 단지번호 붙이기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] isVisit;
    static int apartSize = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Input
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        map = new int[n][n];
        isVisit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                    map[i][j] = s.charAt(j) - '0';
            }
        }
        //Process
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1 && !isVisit[i][j]) {
                    isVisit[i][j] = true;
                    dfs(i, j); //사방탐색하면서 dfs.
                    list.add(apartSize);
                    apartSize = 0;
                }
            }
        }
        //Output
        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void dfs(int y, int x) {
        int dx[] = {0,0,-1,1};
        int dy[] = {-1,1,0,0};
        apartSize++;
        for (int i = 0; i < 4; i++) {
            if(y + dy[i] >= 0 && y + dy[i] < map.length && x + dx[i] >= 0 && x + dx[i] < map[0].length
                    && map[y+dy[i]][x+dx[i]] == 1 && !isVisit[y+dy[i]][x+dx[i]]) {
                isVisit[y+dy[i]][x+dx[i]] = true;
                dfs(y+dy[i], x+dx[i]);
            }
        }
        return;
    }

}
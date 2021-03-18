//15686번. 치킨 배달
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static List<int[]> homeList = new ArrayList<>(); //집 위치 리스트
    static List<int[]> chickenList = new ArrayList<>(); //치킨집 위치 리스트
    static int m;//살아남는 치킨집의 수
    static int[][] distMap;//집과 치킨집의 거리값 배열
    static final int MAX_SIZE = 999999;
    static int minDistance = MAX_SIZE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = stoi(st.nextToken());
                switch(map[i][j]) {
                    case 1 : homeList.add(new int[] {i,j}); break;
                    case 2 : chickenList.add(new int[] {i,j}); break;
                }
            }
        }
        distMap = new int[homeList.size()][chickenList.size()];
        for (int i = 0; i < homeList.size(); i++) {
            for (int j = 0; j < chickenList.size(); j++) {
                calc(i, j);
            }
        }
        int[] sArr = getMaxArr();
        combination(0,0, sArr);
        System.out.println(minDistance);
    }

    static void combination(int cnt, int start, int[] sArr) {
        if(cnt == m) {
            int sumDistance = 0;
            for (int i = 0; i < homeList.size(); i++) {
                sumDistance += sArr[i];
            }
            minDistance = Math.min(sumDistance, minDistance);
            return;
        }
        for (int i = start; i < chickenList.size(); i++) {
            int[] sendArr = getMaxArr();
            for (int j = 0; j < homeList.size(); j++) {
                sendArr[j] = Math.min(distMap[j][i], sArr[j]);
            }
            combination(cnt + 1, i + 1, sendArr);
        }
    }

    private static int[] getMaxArr() {
        int[] sendArr = new int[homeList.size()];
        Arrays.fill(sendArr, MAX_SIZE);
        return sendArr;
    }

    private static void calc(int i, int j) {
        int[] hIdx = homeList.get(i);
        int[] cIdx = chickenList.get(j);
        distMap[i][j] = Math.abs(hIdx[0] - cIdx[0]) + Math.abs(hIdx[1] - cIdx[1]);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
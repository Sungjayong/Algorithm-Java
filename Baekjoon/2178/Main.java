//2178번. 미로 탐색
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = stoi(st.nextToken());
        int c = stoi(st.nextToken());
        arr = new int[r][c];
        isVisit = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            char[] cs = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                arr[i][j] = cs[j] - '0';
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        int[] dc = {0,0,-1,1};
        int[] dr = {-1,1,0,0};
        isVisit[0][0] = true;
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int r = q[0];
            int c = q[1];
            if (r == arr.length - 1 && c == arr[0].length - 1) return q[2];
            else {
                for (int i = 0; i < 4; i++) {
                    if (c + dc[i] >= 0 && r + dr[i] >= 0 && c + dc[i] < arr[0].length && r + dr[i] < arr.length
                            && !isVisit[r + dr[i]][c + dc[i]] && arr[r+dr[i]][c+dc[i]] == 1) {
                        isVisit[r + dr[i]][c + dc[i]] = true;
                        queue.offer(new int[]{r + dr[i], c + dc[i], q[2] + 1});
                    }
                }
            }
        }
        return -1;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
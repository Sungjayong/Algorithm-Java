//7562번. 나이트의 이동
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] isVisit;
    static int eX, eY, sX, sY, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = stoi(br.readLine());
        for (int t = 0; t < testCase; t++) {
            n = stoi(br.readLine());
            board = new int[n][n];
            isVisit = new boolean[n][n];
            st = new StringTokenizer(br.readLine());
            sX = stoi(st.nextToken());
            sY = stoi(st.nextToken());
            st = new StringTokenizer(br.readLine());
            eX = stoi(st.nextToken());
            eY = stoi(st.nextToken());
            System.out.println(bfs());
        }
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sX, sY, 0});
        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
        isVisit[sX][sY] = true;
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int x = q[0];
            int y = q[1];
            if (x == eX && y == eY) return q[2];
            else {
                for (int i = 0; i < 8; i++) {
                    if (x + dx[i] >= 0 && y + dy[i] >= 0 && x + dx[i] < n && y + dy[i] < n
                            && !isVisit[x + dx[i]][y + dy[i]]) {
                        isVisit[x + dx[i]][y + dy[i]] = true;
                        queue.offer(new int[]{x + dx[i], y + dy[i], q[2] + 1});
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
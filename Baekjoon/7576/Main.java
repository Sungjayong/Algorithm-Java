//7576번. 토마토
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] box;
    static Queue<int[]> queue = new LinkedList<>();
    static int r;
    static int c;
    static int effect = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = stoi(st.nextToken());
        r = stoi(st.nextToken());
        int tmtCnt = 0; //익지않은 토마토의 갯수
        box = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                box[i][j] = stoi(st.nextToken());
                if(box[i][j] == 1) { //익은 토마토이면,
                    queue.offer(new int[] {i,j,0});
                }
                if(box[i][j] == 0) tmtCnt++;
            }
        }
        int answer = bfs();
        if(effect == tmtCnt) System.out.println(answer);
        else System.out.println(-1);
    }

    private static int bfs() {
        while(true) {
            int q[] = queue.poll();
            int row = q[0];
            int col = q[1];
            int cnt = q[2];
            int dx[] = {0,0,-1,1};
            int dy[] = {-1,1,0,0};
            for (int i = 0; i < 4; i++) {
                if(row + dy[i] < r && row + dy[i] >= 0 && col + dx[i] < c && col + dx[i] >= 0 &&
                box[row + dy[i]][col + dx[i]] == 0) {
                    box[row + dy[i]][col + dx[i]] = 1;
                    effect++;
                    queue.offer(new int[] {row + dy[i], col + dx[i], cnt + 1});
                }
            }
            if(queue.isEmpty()) {
                return cnt;
            }
        }

    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
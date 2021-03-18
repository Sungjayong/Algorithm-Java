//1743번. 음식물 피하기
//bfs => 4방 탐색 => 큐에 저장,
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<int[]> queue = new LinkedList<>(); //4방 탐색 했을 때 쓰레기의 위치를 넣는 큐
    static int[][] garbageIdx; //모든 쓰레기의 위치 배열.
    static int[][] condo; //모든 위치의 쓰레기 유무 판별.
    static int maxGarbage = 1;
    public static void main(String[] args) throws IOException {
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int garbageNum = Integer.parseInt(st.nextToken());
        garbageIdx= new int[garbageNum][2];
        condo = new int[y][x];
        for (int i = 0; i < garbageNum; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            condo[r-1][c-1] = 1;
            garbageIdx[i][0] = r-1;
            garbageIdx[i][1] = c-1;
        }
        //Processing
        bfs();
        //Output
        System.out.println(maxGarbage);
    }

    private static void bfs() {
        for (int i = 0; i < garbageIdx.length; i++) {
            int gy = garbageIdx[i][0];
            int gx = garbageIdx[i][1];
            if(condo[gy][gx] == 0) continue; //이미 체크된 위치이면 넘어감.
            condo[gy][gx] = 0;
            queue.offer(new int[] {gy, gx});
            int count = 1;
            while(!queue.isEmpty()) {
                int dx[] = {0,0,-1,1};
                int dy[] = {-1,1,0,0};
                int[] ig = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int ndX = ig[1] + dx[j];
                    int ndY = ig[0] + dy[j];
                    if(ndX >= 0 && ndX < condo[0].length && ndY >= 0 && ndY < condo.length
                            && condo[ndY][ndX] == 1) {
                        queue.offer(new int[] {ndY, ndX}); //큐에 추가시켜주고,
                        condo[ndY][ndX] = 0; //해당 위치 접근했다고 선언 후,
                        if(maxGarbage < ++count) maxGarbage = count;
                    }
                }
            }
        }
    }
}
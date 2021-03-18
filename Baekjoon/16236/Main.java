//16236번. 아기 상어
import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int size = 2;
        int eating = 0;
        int x;
        int y;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int[][] map = new int[n][n];
        boolean[][] isVisit = new boolean[n][n];
        Shark shark = new Shark();
        int[] dx = {0,-1,1,0};
        int[] dy = {-1,0,0,1};
        int time = 0;
        int fishNum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = stoi(st.nextToken());
                if(map[i][j] == 9) {
                    shark.x = j;
                    shark.y = i;
                } else if(map[i][j] != 0) {
                    fishNum++;
                }
            }
        }

        //더이상 먹을 수 있는 물고기가 존재하지 않거나, 먹을 수 없을 경우가 아니라면
        //잡아 먹을 수 있는 물고기 중 가장 가까운 물고기의 위치를 찾는다.
        int deadNum = 0;
        while(true) {
            boolean isEat = false;
            Queue<int[]> queue = new LinkedList<>();
            isVisit[shark.y][shark.x] = true;
            queue.offer(new int[] {shark.y,shark.x});
            int cnt = 1;
            while(!queue.isEmpty()) {
                int size = queue.size();
                ArrayList<int[]> candidate = new ArrayList<>();
                while(--size >= 0) {
                    int[] q = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int mx = q[1] + dx[i];
                        int my = q[0] + dy[i];
                        if(mx >= 0 && mx < n && my >= 0 && my < n && !isVisit[my][mx]) {
                            isVisit[my][mx] = true;
                            if(map[my][mx] == 0 || map[my][mx] == shark.size) { //빈공간 or 같은 크기의 물고기 => 다음 위치 탐색을 위해 큐에 추가.
                                queue.offer(new int[] {my,mx});
                            }
                            else if(map[my][mx] < shark.size) { //잡아먹을수 있는 물고기면?
                                candidate.add(new int[]{my,mx});
                                isEat = true;
                            }
                        }
                    }
                }
                if(isEat) { //먹을 수 있는 좌표들 중, 가장 위에 있고 그 다음 왼쪽에 있는 물고기의 좌표를 구함.
                    int mmy = candidate.get(0)[0];
                    int mmx = candidate.get(0)[1];
                    for (int i = 1; i < candidate.size(); i++) {
                        if(mmy < candidate.get(i)[0]) continue;
                        else if(mmy == candidate.get(i)[0] && mmx < candidate.get(i)[1]) continue;
                        else {
                            mmy = candidate.get(i)[0];
                            mmx = candidate.get(i)[1];
                        }
                    }
                    time += cnt;
                    map[shark.y][shark.x] = 0;
                    map[mmy][mmx] = 9;
                    shark.eating++;
                    shark.x = mmx;
                    shark.y = mmy;
                    deadNum++;

                    if(shark.size == shark.eating) {
                        shark.size++;
                        shark.eating = 0;
                    }
                    queue.clear();
                    for(boolean v[] : isVisit) {
                        Arrays.fill(v, false);
                    }
                }
                cnt++;
            }
            if(deadNum == fishNum) break;
            if(!isEat) break;
        }
        System.out.println(time);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}




















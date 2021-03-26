//17422번. 다리 만들기 2
import java.io.*;
import java.util.*;

public class Main {
    static class Index {
        int r,c;
        public Index(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static class Edge implements Comparable<Edge> {
        int from,to,weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    "}\n";
        }
    }
    static int[][] arr;
    static boolean[][] isVisit;
    static ArrayList<Edge> edgeList = new ArrayList<>();
    static int r,c;
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = stoi(st.nextToken());
        c = stoi(st.nextToken());
        arr = new int[r][c];
        isVisit = new boolean[r][c];

        //input
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = stoi(st.nextToken());
            }
        }

        //bfs를 통해 각 섬마다 고유한 값을 설정해 줌.
        int idx = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!isVisit[i][j] && arr[i][j] == 1) {
                    isVisit[i][j] = true;
                    bfs(i,j, ++idx);
                }
            }
        }
//        System.out.println(Arrays.deepToString(arr));

        parents = new int[idx + 1];
        //섬에 대하여 모든 선분들을 Vertex List에 넣어준다.
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(arr[i][j] != 0) {
                    addVertex(i,j, arr[i][j]);
                }
            }
        }
//        System.out.println(edgeList);
        //weigth 기준 정렬 후 크루스칼
        Collections.sort(edgeList);
        make();
        int result = 0;
        int count = 0; //선택한 간선 수
        boolean success = false;
        for (Edge edge : edgeList) {
            if(union(edge.from, edge.to)) { //싸이클이 발생 x
                result += edge.weight;
                if(++count == idx - 1) {
                    success = true;
                    break;
                }
            }
        }
        if(success) System.out.println(result);
        else System.out.println(-1);
    }


    private static void addVertex(int i, int j, int idx) {
        for (int k = 0; k < 4; k++) {
            int mr = i + dr[k];
            int mc = j + dc[k];
            int len = 0;
            int arrival = -1;
            while(true) {
                if(mr >= 0 && mr < r && mc >= 0 && mc < c && arr[mr][mc] != idx) {
                    if(arr[mr][mc] == 0) {
                        len++;
                        mr += dr[k];
                        mc += dc[k];
                    } else {
                        arrival = arr[mr][mc];
                        break;
                    }
                } else break; //범위 밖이면 변경할 점 x
            }
            if(len >= 2 && arrival != -1) {
                edgeList.add(new Edge(idx, arrival, len));
            }
        }
    }

    private static void bfs(int i, int j, int idx) {
        Queue<Index> queue = new LinkedList<>();
        queue.offer(new Index(i,j));
        arr[i][j] = idx;
        while(!queue.isEmpty()) {
            Index q = queue.poll();
            for (int k = 0; k < 4; k++) {
                int mr = q.r + dr[k];
                int mc = q.c + dc[k];
                if(mr >= 0 && mr < r && mc >= 0 && mc < c && !isVisit[mr][mc] && arr[mr][mc] == 1) {
                    isVisit[mr][mc] = true;
                    arr[mr][mc] = idx;
                    queue.offer(new Index(mr,mc));
                }
            }
        }
    }

    static void make() { //크기가 1인 단위집합을 만든다.
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if(parents[a] == a) return a;
        return parents[a] = findSet(parents[a]); //path compression 후
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
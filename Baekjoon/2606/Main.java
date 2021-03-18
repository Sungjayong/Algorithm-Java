//2606번. 바이러스
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int comNum;
    static int[][] graph;
    static boolean[] isVirus;
    static int virus = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        comNum = stoi(br.readLine());
        int connectNum = stoi(br.readLine());
        graph = new int[comNum][comNum];
        isVirus = new boolean[comNum];
        isVirus[0] = true; //1번 컴퓨터는 미리 감염.
        for (int i = 0; i < connectNum; i++) {
            st = new StringTokenizer(br.readLine());
            int one = stoi(st.nextToken()) - 1;
            int two = stoi(st.nextToken()) - 1;
            graph[one][two] = 1;
            graph[two][one] = 1;
        }
        dfs(0);//컴퓨터 인덱스로 생각해서 1 => 0
        System.out.println(virus);
    }

    private static void dfs(int c) {
        for (int i = 0; i < comNum; i++) {
            if(graph[c][i] == 1 && !isVirus[i]) {
                virus++;
                isVirus[i] = true;
                dfs(i);
            }
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
//11403번. 경로 찾기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        int[][] route = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //Process
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            boolean[] isCheck = new boolean[n];
            while(!queue.isEmpty()) {
                int q = queue.poll();
                for (int j = 0; j < n; j++) {
                    if(graph[q][j] == 1 && !isCheck[j]) {
                        route[i][j] = 1;
                        isCheck[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }

        //Output
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(route[i][j] + " ");
            }
            System.out.println();
        }
    }
}
//7568번 : 덩치
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] weight;
    static int[] height;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        weight = new int[n];
        height = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) { //기준
            for (int j = 0; j < n; j++) { //비교군
                if (i != j && weight[i] < weight[j] && height[i] < height[j]) {
                    rank[i]++;
                }
            }
            rank[i]++;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(rank[i] + " ");
        }
    }
}
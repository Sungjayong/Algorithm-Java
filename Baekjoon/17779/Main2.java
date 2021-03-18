//17779번. 게리맨더링 2
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//특정 사각형을 설정.
//각각 구역들의 값들을 구해준 다음 가장 큰 값에서 가장 작은 값을 빼줌.

public class Main2 {
    static int[][] graph;
    static int n;
    static boolean[][] isCheck;
    static int minNum = Integer.MAX_VALUE;
    static int maxNum = Integer.MIN_VALUE;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        graph = new int[n][n];
        isCheck = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = stoi(st.nextToken());
            }
        }
        for (int size = 1; size < n/2 + 1; size++) {
            for (int y = 0; y < n - size * 2; y++) {
                for (int x = size; x < n - size; x++) {
                    int top[] = new int[] {x,y};
                    int left[] = new int[] {x - size, y + size};
                    int right[] = new int[] {x + size, y + size};
                    int bottom[] = new int[] {x, y + 2 * size};
                    calc(top, left, right, bottom, size);
                    while(left[0] - 1 > 0 && bottom[1] + 1 < n) { //왼쪽으로 커질 수 있고, 아래로 커질 수 있으면
                        left = new int[]{left[0] - 1, left[1] + 1};
                        bottom = new int[]{bottom[0] - 1, bottom[1] + 1};
                        calc(top,left,right,bottom, size);
                    }
                    
                    //원래대로 초기화.
                    left = new int[] {x - size, y + size};
                    bottom = new int[] {x, y + 2 * size};
                    
                    while(right[0] + 1 < n - 1 && bottom[1] + 1 < n) { //오른쪽으로 커질 수 있고, 아래로 커질 수 있으면
                        right = new int[]{right[0] + 1, right[1] + 1};
                        bottom = new int[]{bottom[0] + 1, bottom[1] + 1};
                        calc(top,left,right,bottom,size);
                    }
                }
            }
        }
        System.out.println(minDiff);

    }

    private static void calc(int[] top, int[] left, int[] right, int[] bottom, int size) {
        for(boolean b[]:isCheck) {
            Arrays.fill(b,false);
        }
        minNum = Integer.MAX_VALUE;
        maxNum = Integer.MIN_VALUE;

        int oneSum = calcOne(top, left);
        int twoSum = calcTwo(top, right);
        int threeSum = calcThree(left, bottom);
        int fourSum = calcFour(right, bottom);
        int fiveSum = calcFive(top, left, right, bottom, size);
        minDiff = Math.min(maxNum - minNum, minDiff);
    }

    private static int calcOne(int[] top, int[] left) {
        int sum = 0;
        for (int i = 0; i < top[1]; i++) { //y축
            for (int j = 0; j <= top[0]; j++) { //x축
                sum += graph[i][j];
                isCheck[i][j] = true;
            }
        }
        int k = top[0];
        for (int i = top[1]; i < left[1]; i++) {//y축
            for (int j = 0; j < k; j++) {
                sum += graph[i][j];
                isCheck[i][j] = true;
            }
            k--;
        }
        minNum = Math.min(sum, minNum);
        maxNum = Math.max(sum, maxNum);
        return sum;
    }

    private static int calcTwo(int[] top, int[] right) {
        int sum = 0;
        for (int i = 0; i <= top[1]; i++) { //y축
            for (int j = top[0] + 1; j < n; j++) { //x축
                sum += graph[i][j];
                isCheck[i][j] = true;
            }
        }
        int k = top[0] + 2;
        for (int i = top[1] + 1; i <= right[1]; i++) {
            for (int j = k; j < n; j++) {
                sum += graph[i][j];
                isCheck[i][j] = true;
            }
            k++;
        }
        minNum = Math.min(sum, minNum);
        maxNum = Math.max(sum, maxNum);
        return sum;
    }

    private static int calcThree(int[] left, int[] bottom) {
        int sum = 0;
        for (int i = bottom[1]; i < n; i++) {
            for (int j = 0; j < bottom[0]; j++) {
                sum += graph[i][j];
                isCheck[i][j] = true;
            }
        }
        int k = left[0];
        for (int i = left[1]; i <bottom[1]; i++) {
            for (int j = 0; j < k; j++) {
                sum += graph[i][j];
                isCheck[i][j] = true;
            }
            k++;
        }
        minNum = Math.min(sum, minNum);
        maxNum = Math.max(sum, maxNum);
        return sum;
    }

    private static int calcFour(int[] right, int[] bottom) {
        int sum = 0;
        for (int i = bottom[1]+ 1; i < n; i++) { //y축
            for (int j = bottom[0]; j < n; j++) { //x축
                sum += graph[i][j];
                isCheck[i][j] = true;
            }
        }
        int k = right[0];
        for (int i = right[1] + 1; i <= bottom[1] && i <= n; i++) {//y축
            for (int j = k; j < n; j++) {//x축
                sum += graph[i][j];
                isCheck[i][j] = true;
            }
            k--;
        }
        minNum = Math.min(sum, minNum);
        maxNum = Math.max(sum, maxNum);
        return sum;
    }

    private static int calcFive(int[] top, int[] left, int[] right, int[] bottom, int size) {
        int sum = 0;
        for (int i = top[1]; i <= bottom[1]; i++) {
            for (int j = left[0]; j <= right[0]; j++) {
                if(!isCheck[i][j]) {
                    sum += graph[i][j];
                }
            }
        }
        minNum = Math.min(sum, minNum);
        maxNum = Math.max(sum, maxNum);
        return sum;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
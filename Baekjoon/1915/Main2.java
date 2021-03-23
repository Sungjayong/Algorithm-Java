//1915번. 가장 큰 정사각형
import java.io.*;
import java.util.StringTokenizer;

public class Main2 {
    static int maxLine;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = stoi(st.nextToken());
        int c = stoi(st.nextToken());
        maxLine = 0;
        int[][] arr = new int[r][c];

        //Input
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        //Process
        for (int i = 0; i < r; i++) { //0행에 1이 존재하는 지 확인.
            if(arr[i][0] == 1) {
                maxLine = 1;
                break;
            }
        }

        for (int i = 0; i < c; i++) { //0열에 1이 존재하는 지 확인.
            if(arr[0][i] == 1) {
                maxLine = 1;
                break;
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if(arr[i][j] == 1) {
                    int left = arr[i][j-1];
                    int top = arr[i-1][j];
                    int diagonal = arr[i-1][j-1];
                    arr[i][j] = myMin(left,top,diagonal);
                    maxLine = Math.max(arr[i][j], maxLine);
                }
            }
        }
        System.out.println(maxLine * maxLine);
    }

    private static int myMin(int a, int b, int c) {
        if(a == 0 || b == 0 || c== 0) return 1; //0이 존재하면 1의 값으로 유지
        else return(Math.min(a,Math.min(b,c)) + 1);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}







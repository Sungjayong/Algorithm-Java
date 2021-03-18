//16935번 : 배열 돌리기 3
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    static int[][] arr;
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //Input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int r = 0 ; r < N ; ++r) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < M ; ++c) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        //Processing
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < R ; ++i) {
            int command = Integer.parseInt(st.nextToken());

            switch(command) {
                case 1: upDownReversal(); break;
                case 2: leftRightReversal(); break;
                case 3: rightRotate(); break;
                case 4: leftRotate(); break;
                case 5: clockRotate(); break;
                case 6: counterClockRotate(); break;
            }
        }

        for(int r = 0; r < arr.length ; ++r) {
            for(int c = 0; c < arr[0].length ; ++c) {
                System.out.print(arr[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void upDownReversal() {
        for(int c = 0; c < arr[0].length ; ++c) {
            for(int r1 = 0, r2 = arr.length - 1; r1 < r2 ; r1++, r2--) {
                int temp = arr[r1][c];
                arr[r1][c] = arr[r2][c];
                arr[r2][c] = temp;
            }
        }
    }

    private static void leftRightReversal() {
        for(int r = 0; r < arr.length ; ++r) {
            for(int c1 = 0, c2 = arr[0].length - 1; c1 < c2 ; c1++, c2--) {
                int temp = arr[r][c1];
                arr[r][c1] = arr[r][c2];
                arr[r][c2] = temp;
            }
        }
    }

    private static void rightRotate() {
        int[][] result = new int[arr[0].length][arr.length];

        for(int r = 0; r < arr.length ; ++r) {
            for(int c = 0; c < arr[0].length ; ++c) {
                result[c][arr.length - 1 - r] = arr[r][c];
            }
        }
        arr = result;
    }

    private static void leftRotate() {
        int[][] result = new int[arr[0].length][arr.length];

        for(int r = 0 ; r < result.length ; ++r) {
            for(int c = 0 ; c < result[0].length ; ++c) {
                result[r][c] = arr[c][result.length - 1 - r];
            }
        }
        arr = result;
    }

    private static void clockRotate() {
        int[][] cArr = new int[arr.length][arr[0].length];

        int rowSize = arr.length;
        int colSize = arr[0].length;

        for(int r = 0 ; r < rowSize / 2 ; ++r) {
            for(int c = 0 ; c < colSize / 2 ; ++c) {
                cArr[r][c + colSize / 2] = arr[r][c];
            }
        }
        for(int r = 0 ; r < rowSize / 2 ; ++r) {
            for(int c = colSize / 2 ; c < colSize ; ++c) {
                cArr[r + rowSize / 2][c] = arr[r][c];
            }
        }
        for(int r = rowSize / 2 ; r < rowSize ; ++r) {
            for(int c = colSize / 2 ; c < colSize ; ++c) {
                cArr[r][c - colSize / 2] = arr[r][c];
            }
        }
        for(int r = rowSize / 2 ; r < rowSize ; ++r) {
            for(int c = 0 ; c < colSize / 2 ; ++c) {
                cArr[r - rowSize / 2][c] = arr[r][c];
            }
        }
        arr = cArr;
    }

    private static void counterClockRotate() {
        int[][] cArr = new int[arr.length][arr[0].length];

        int rowSize = arr.length;
        int colSize = arr[0].length;

        for(int r = 0 ; r < rowSize / 2 ; ++r) {
            for(int c = 0 ; c < colSize / 2 ; ++c) {
                cArr[r + rowSize / 2][c] = arr[r][c];
            }
        }
        for(int r = rowSize / 2 ; r < rowSize ; ++r) {
            for(int c = 0 ; c < colSize / 2 ; ++c) {
                cArr[r][c + colSize / 2] = arr[r][c];
            }
        }
        for(int r = rowSize / 2 ; r < rowSize ; ++r) {
            for(int c = colSize / 2 ; c < colSize ; ++c) {
                cArr[r - rowSize / 2][c] = arr[r][c];
            }
        }
        for(int r = 0 ; r < rowSize / 2 ; ++r) {
            for(int c = colSize / 2 ; c < colSize ; ++c) {
                cArr[r][c - colSize / 2] = arr[r][c];
            }
        }
        arr = cArr;
    }


}
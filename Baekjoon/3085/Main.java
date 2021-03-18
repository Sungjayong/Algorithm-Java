//3085번 : 사탕 게임
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) { //배열에 내용 입력.
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int max = 0;
        int sum = 1;
        char before = '.';
        char now = '.';
        //i, j 는 스왑용도로 사용. 스왑 후 j, k를 이용해 완탐
        for (int i = 0; i < n - 1; i++) { //세로 자리 변화
            for (int j = 0; j < n; j++) {
                swap(i, j, i + 1, j); //위에 사탕이랑 바로 아래 사탕이랑 위치 변경
                for (int k = 0; k < n; k++) { //가로로 이동하면서 한 줄의 최대 중복값 확인.
                    for (int l = 0; l < n; l++) {
                        now = arr[k][l];
                        if (before == now) {
                            sum++;
                        } else {
                            if(max < sum) {
                                max = sum;
                            }
                            sum = 1;
                        }
                        before = now;
                    }
                    if(max < sum) max = sum;
                    sum = 1;
                    before = '.';
                }
                for (int l = 0; l < n; l++) { //세로로 이동하면서 한 줄의 최대 중복값 확인.
                    for (int k = 0; k < n; k++) {
                        now = arr[k][l];
                        if (before == now) {
                            sum++;
                        } else {
                            if(max < sum) {
                                max = sum;
                            }
                            sum = 1;
                        }
                        before = now;
                    }
                    if(max < sum) max = sum;
                    sum = 1;
                    before = '.';
                }
                swap(i + 1, j, i, j); //위치 변경했던 것 제자리.
            }
        }
        for (int i = 0; i < n; i++) { //가로 자리 변화
            for (int j = 0; j < n - 1; j++) {
                swap(i, j, i, j + 1); //기준 사탕이랑 바로 오른쪽 사탕이랑 위치 변경
                for (int k = 0; k < n; k++) { //가로로 이동하면서 한 줄의 최대 중복값 확인.
                    for (int l = 0; l < n; l++) {
                        now = arr[k][l];
                        if (before == now) {
                            sum++;
                        } else {
                            if(max < sum) {
                                max = sum;
                            }
                            sum = 1;
                        }
                        before = now;
                    }
                    if(max < sum) max = sum;
                    sum = 1;
                    before = '.';
                }
                for (int l = 0; l < n; l++) { //세로로 이동하면서 한 줄의 최대 중복값 확인.
                    for (int k = 0; k < n; k++) {
                        now = arr[k][l];
                        if (before == now) {
                            sum++;
                        } else {
                            if(max < sum) {
                                max = sum;
                            }
                            sum = 1;
                        }
                        before = now;
                    }
                    if(max < sum) max = sum;
                    sum = 1;
                    before = '.';
                }
                swap(i, j, i, j + 1); //위치 변경했던 것 제자리.
            }
        }
        System.out.println(max);
    }

    public static void swap(int ay, int ax, int by, int bx) {
        char temp = arr[ay][ax];
        arr[ay][ax] = arr[by][bx];
        arr[by][bx] = temp;
    }
}
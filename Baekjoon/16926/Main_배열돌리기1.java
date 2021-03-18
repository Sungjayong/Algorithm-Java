//16926 : 배열 돌리기 1
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(str.nextToken());
        int col = Integer.parseInt(str.nextToken());
        int r = Integer.parseInt(str.nextToken());
        int arr[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //Processing
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        while(row - cnt * 2 > 0 && col - cnt * 2 > 0) {
            for (int i = cnt; i < col - cnt; i++) {
                queue.offer(arr[cnt][i]);
            }
            for (int j = cnt + 1; j < row - cnt ; j++) {
                queue.offer(arr[j][col - cnt - 1]);
            }
            for (int i = col - cnt - 2; i >= cnt; i--) {
                queue.offer(arr[row - cnt - 1][i]);
            }
            for (int j = row - cnt - 2; j > cnt; j--) {
                queue.offer(arr[j][cnt]);
            }
            int spin;
            spin = r;
            if(!queue.isEmpty()) spin = r % queue.size();
            while (spin > 0) { //원한 만큼 회전.
                spin--;
                queue.offer(queue.poll());
            }

            for (int i = cnt; i < col - cnt; i++) {
                arr[cnt][i] = queue.poll();
            }
            for (int j = cnt + 1; j < row - cnt; j++) {
                arr[j][col - cnt - 1] = queue.poll();
            }
            for (int i = col - cnt - 2; i >= cnt; i--) {
                arr[row - cnt - 1][i] = queue.poll();
            }
            for (int j = row - cnt - 2; j > cnt; j--) {
                arr[j][cnt] = queue.poll();
            }
            cnt++;
        }
        //Output
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
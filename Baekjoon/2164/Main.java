//2164번. 카드 2
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int n = stoi(br.readLine());
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while(queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());
    }
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
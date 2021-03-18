//9019번. DSLR
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = stoi(br.readLine());
        for (int t = 0; t < testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            System.out.println(bfs(s,b));
        }
        return;
    }

    private static String bfs(int s, int b) {
        Queue<StringBuilder> queue = new LinkedList<>();
        Queue<Integer> queueNum = new LinkedList<>();
        boolean[] isVisit = new boolean[10000];
        queue.offer(new StringBuilder(""));
        queueNum.offer(s);
        while(!queue.isEmpty()) {
            StringBuilder sb = queue.poll();
            int num = queueNum.poll();
            if(b == num) return sb.toString();
            if(!isVisit[num]) {
                isVisit[num] = true;
                StringBuilder dsb = new StringBuilder(sb.toString());
                queue.offer(dsb.append("D"));
                queueNum.offer(2*num % 10000);

                StringBuilder ssb = new StringBuilder(sb.toString());;
                queue.offer(ssb.append("S"));
                if (num == 0) queueNum.offer(9999);
                else queueNum.offer(num - 1);

                //1234 -> 2341
                StringBuilder lsb = new StringBuilder(sb.toString());;
                queue.offer(lsb.append("L"));
                queueNum.offer(num/1000 + (num % 1000) * 10);

                //1234 -> 4123
                StringBuilder rsb = new StringBuilder(sb.toString());;
                queue.offer(rsb.append("R"));
                queueNum.offer(num/10 + ((num % 10) * 1000));
            }
        }
        return "error";
    }
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
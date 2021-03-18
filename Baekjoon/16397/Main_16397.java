import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16397 {
    static int minBtn = 100000;
    static Queue<int[]> queue = new LinkedList<>();//값과 횟수.
    static HashSet<Integer> hs = new HashSet<>();
    static int n;
    static int t;
    static int g;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //현재의 수.
        t = Integer.parseInt(st.nextToken()); //버튼 가능 횟수.
        g = Integer.parseInt(st.nextToken()); //만들어야하는 수.
        bfs();
        if(minBtn == -1) {
            System.out.println("ANG");
        } else System.out.println(minBtn);

    }

    public static void bfs() {
        queue.offer(new int[] {n, 0});
        while(true) {
            if(queue.isEmpty()) { //큐가 비어있다. => 가능한 경우의 수가 없다.
                minBtn = -1;
                break;
            }
            int[] test = queue.poll();
            int nowNum = test[0];
            int nowCount = test[1];
            if(t < nowCount) { //시도횟수가 t를 넘어버린다면
                minBtn = -1;
                break;
            }
            else if(nowNum == g) { //원하는 값 달성 시 탈출 성공.
                minBtn = nowCount;
                break;
            }
            else if(nowNum > 99999) { //a,b 둘 중 뭐를 눌러도 6자리가 되므로,
                continue;
            }
            if(!hs.contains(nowNum+1)){
                queue.offer(new int[] {nowNum + 1, nowCount + 1}); //a버튼 클릭 이벤트를 큐에 저장.
                hs.add(nowNum+1);
            }
            if(nowNum * 2 > 99999 || nowNum == 0) { //n이 0이거나, 2를 곱한 순간 수가 99999를 넘는다면,
                continue;
            }
            String s = Integer.toString(nowNum * 2);//123 = > 246
            StringBuilder bn = new StringBuilder("");
            bn.append(s.charAt(0) - '1');
            for (int i = 1; i < s.length(); i++) { //b버튼 처리.
                bn.append(s.charAt(i));
            }
            if(!hs.contains(Integer.parseInt(bn.toString()))){
                queue.offer(new int[] {Integer.parseInt(bn.toString()), nowCount + 1}); //b버튼 클릭 이벤트를 큐에 저장.
                hs.add(Integer.parseInt(bn.toString()));
            }
        }
    }

}

//17471번. 게리멘더링
import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] isConnect;
    static boolean[] isSelected;
    static int[] population;
    static int n;
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = stoi(br.readLine());
        isConnect = new boolean[n+1][n+1];
        population = new int[n+1];
        isSelected = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            population[i] = stoi(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int conn = stoi(st.nextToken());
            while (conn-- > 0) {
                int nd = stoi(st.nextToken());
                isConnect[i][nd] = true;
                isConnect[nd][i] = true;
            }
        }
        subset(1);
        if(minDiff == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minDiff);
    }

    private static void subset(int cnt) {
        if(cnt == n+1) {
            if(checkConn()) {
                int sum = 0;
                for (int i = 1; i <= n; i++) {
                    if(isSelected[i]) sum += population[i];
                    else sum -= population[i];
                }
                minDiff = Math.min(minDiff, Math.abs(sum));
            }
            return;
        }
        isSelected[cnt] = true;
        subset(cnt+1);
        isSelected[cnt] = false;
        subset(cnt+1);
    }

    private static boolean checkConn() {
        ArrayList<Integer> aGroup = new ArrayList<>();
        ArrayList<Integer> bGroup = new ArrayList<>();
        ArrayList<Integer> comp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(isSelected[i]) aGroup.add(i);
            else bGroup.add(i);
        }
        if(aGroup.size() == 0 || bGroup.size() == 0) return false;
        if(aGroup.size() != 1) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(aGroup.get(0));
            comp.add(aGroup.get(0));

            boolean[] isVisit = new boolean[n+1];
            isVisit[aGroup.get(0)] = true;
            while(!queue.isEmpty()) {
                int q = queue.poll();
                for (int i = 1; i <= n; i++) {
                    if(isConnect[q][i] && aGroup.contains(i) && !isVisit[i]) {
                        isVisit[i] = true;
                        comp.add(i);
                        queue.offer(i);
                    }
                }
            }
            for (int i = 0; i < aGroup.size(); i++) {
                if(!comp.contains(aGroup.get(i))) return false;
            }
        }

        comp.clear();
        if(bGroup.size() != 1) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(bGroup.get(0));
            comp.add(bGroup.get(0));
            boolean[] isVisit = new boolean[n+1];
            isVisit[bGroup.get(0)] = true;
            while(!queue.isEmpty()) {
                int q = queue.poll();
                for (int i = 1; i <= n; i++) {
                    if(isConnect[q][i] && bGroup.contains(i) && !isVisit[i]) {
                        isVisit[i] = true;
                        comp.add(i);
                        queue.offer(i);
                    }
                }
            }
            for (int i = 0; i < bGroup.size(); i++) {
                if(!comp.contains(bGroup.get(i))) return false;
            }
        }
        return true;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}





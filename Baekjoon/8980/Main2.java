//8980번. 택배
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static class Box implements Comparable<Box> {
        int start; //보내는 마을 인덱스
        int end; //받는 마을 인덱스
        int weight; // 박스 개수

        public Box(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Box o) {
            int diff = this.end - o.end;
            return diff == 0 ? o.start - this.start : diff;
        }

        @Override
        public String toString() {
            return "Box{" + "start=" + start + ", end=" + end + ", weight=" + weight + '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int townNum = stoi(st.nextToken());
        int town[] = new int[townNum];
        int sumWeight = 0;
        int volume = stoi(st.nextToken());
        Arrays.fill(town, volume);
        int boxNum = stoi(br.readLine());
        Box[] box = new Box[boxNum];
        for (int i = 0; i < boxNum; i++) {
            st = new StringTokenizer(br.readLine());
            box[i] = new Box(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
        }
        Arrays.sort(box);
        for(Box b : box) {
            boolean isLoad = true;
            for (int i = b.start; i < b.end; i++) {
                if(town[i] < b.weight) {
                    if(town[i] == 0) { // 어떤 상자도 실을 수 없으므로
                        isLoad = false;
                        break;
                    }
                    b.weight = town[i];
                }
            }
            if(isLoad) {
                for (int i = b.start; i < b.end; i++) {
                    town[i] -= b.weight;
                }
                sumWeight += b.weight;
            }
        }
        System.out.println(sumWeight);
    }
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
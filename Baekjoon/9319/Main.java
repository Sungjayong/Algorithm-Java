import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int bnLevel = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String xy[] = input.split(" "); // x, y
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            float max = 0;
            float sum = 0;
            int idx = -1; //max의 위치 값
            for (int j = 0; j < n; j++) {
                String input2 = br.readLine();
                String xys[] = input2.split(" "); //px, py, s
                int px = Integer.parseInt(xys[0]);
                int py = Integer.parseInt(xys[1]);
                int s = Integer.parseInt(xys[2]);
                float r = (s / (float)(pow(abs(px-x),2) + pow(abs(py-y),2)));
                if (r > max) {
                    max = r;
                    idx = j;
                }
                sum += r;
            }
            if (max > 6 * (bnLevel + sum - max)){
                System.out.println(idx+1);
            } else System.out.println("NOISE");
        }
        br.close();
        return;
    }
}

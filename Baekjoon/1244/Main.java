import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] light = new boolean[n]; //나름 메모리 아낀다고 boolean으로 해주었습니다..ㅎㅎ;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            if (st.nextToken().equals("1")) light[i] = true;
            else  light[i] = false;
        }
        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i < q; i++){
            StringTokenizer stq = new StringTokenizer(br.readLine(), " ");
            switch(stq.nextToken()) {
                case "1": //남학생
                    int standard = Integer.parseInt(stq.nextToken());
                    for(int j = standard - 1; j < n; j += standard) {
                        light[j] = !light[j];
                    }
                    break;
                case "2": //여학생
                    int cnt = 1;
                    boolean isIn = true;
                    standard = Integer.parseInt(stq.nextToken()) - 1;
                    light[standard] = !light[standard]; //기준 전구부터 변경.
                    try{
                        while(light[standard - cnt] == light[standard + cnt] && isIn) {
                            light[standard - cnt] = !light[standard - cnt];
                            light[standard + cnt] = !light[standard + cnt];
                            cnt++;
                        }
                    } catch(ArrayIndexOutOfBoundsException e) {
                        isIn = false;
                        continue;
                    }
                    break;
            }
        }
        int printNum = 0;
        for(boolean b : light) {
            if(b == true) System.out.print("1 ");
            else System.out.print("0 ");
            printNum++;
            if(printNum % 20 == 0) {
                System.out.println();
            }
        }
    }
}
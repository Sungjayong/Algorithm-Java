// 21921번. 블로그
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int operationPeriod = stoi(st.nextToken());
        int daySize = stoi(st.nextToken());
        int[] visitorNum = new int[operationPeriod];

        int equalCount = 1;
        int maxVisitorSum = 0;
        int visitorSumPerPeriod = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operationPeriod; i++) {
            visitorNum[i] = stoi(st.nextToken());
        }

        for (int i = 0; i < daySize; i++) {
            visitorSumPerPeriod += visitorNum[i];
        }
        maxVisitorSum = visitorSumPerPeriod;

        for (int i = 0; i < operationPeriod - daySize; i++) {
            visitorSumPerPeriod = visitorSumPerPeriod - visitorNum[i] + visitorNum[daySize + i];
            if (maxVisitorSum < visitorSumPerPeriod) {
                maxVisitorSum = visitorSumPerPeriod;
                equalCount = 1;
            }
            else if(maxVisitorSum == visitorSumPerPeriod) {
                equalCount++;
            }
        }

        if (maxVisitorSum == 0) System.out.println("SAD");
        else System.out.println(maxVisitorSum + "\n" + equalCount);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
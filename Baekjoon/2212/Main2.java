//2212번. 센서
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
// 1 3 6 6 7 8 9
//  2 3 0 1 1 1
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sensorNum = stoi(br.readLine());//센서 개수
        int stationNum = stoi(br.readLine());//기지국 개수
        int[] sensorIdx = new int[sensorNum];//센서 위치들
        int[][] idxDiff = new int[sensorNum - 1][2];//센서들 간 거리
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sensorNum; i++) {
            sensorIdx[i] = stoi(st.nextToken());
        }
        Arrays.sort(sensorIdx);

        for (int i = 0; i < sensorNum - 1; i++) {
            idxDiff[i][0] = sensorIdx[i+1] - sensorIdx[i];
            idxDiff[i][1] = i;
        }
        Arrays.sort(idxDiff, (o1,o2) -> o2[0] - o1[0]); //내림차순.
        int sum = 0;
        for (int i = stationNum - 1; i < idxDiff.length; i++) {
            sum += idxDiff[i][0];
        }
        System.out.println(sum);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
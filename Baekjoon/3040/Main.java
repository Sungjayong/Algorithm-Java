//3040번. 백설 공주와 일곱 난쟁이
import java.io.*;

public class Main {
    static int[] dwarf = new int[9]; // 난쟁이들 모자의 숫자.
    static boolean[] isSelected = new boolean[9]; // 선택된 난쟁이들 확인 배열.
    static boolean isFind = false; //찾았는지 확인.
    public static void main(String[] args) throws IOException {
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }
        //Process
        perm(0,0);
    }

    private static void perm(int cnt, int sum) {
        if(isFind) return;
        if(cnt == 7) {
            if(sum == 100){
                for (int i = 0; i < 9; i++) {
                    if(isSelected[i]) {
                        System.out.println(dwarf[i]);
                    }
                }
                isFind = true;
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            perm(cnt+1,sum+dwarf[i]);
            isSelected[i] = false;

        }
    }
}
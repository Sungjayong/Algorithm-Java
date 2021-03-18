import java.util.Scanner;
//정작 홀수일 때 cy이기고, 짝수 일 때 sk가 이기지만, dp 개념으로 풀어보면 이렇게 되네용
class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       boolean[] win = new boolean[n]; //true : 처음 사람, false : 두번째 사람 승리
       if (n == 1) {
           System.out.println("CY");
           return;
        }
        if (n == 2) {
            System.out.println("SK");
            return;
        }
        if (n == 3) {
            System.out.println("CY");
            return;
        }
       win[0] = false;
       win[1] = true;
       win[2] = false;
       for (int i = 3; i < n; i++){
           if(win[i - 1] && win[i - 3]) {
               win[i] = false;
           } else{
               win[i] = true;
           }
       }
        if(win[n-1]) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}

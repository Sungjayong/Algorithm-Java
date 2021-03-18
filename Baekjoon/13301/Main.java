import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n == 1) {
            System.out.println(4);
            return;
        }
        long arr[] = new long[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 2 ; i < n+1; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(4 * arr[n] + 2 * arr[n-1]);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int in = Integer.parseInt(n);

        for (int i = in > 36 ? in - n.length() * 9 : 0; i < in; i++) {
            String cons = Integer.toString(i);
            int sum = i;
            for (int j = 0; j < cons.length(); j++) {
                sum += Integer.parseInt(String.valueOf(cons.charAt(j))); // char => string => int
            }
            if(sum == Integer.parseInt(n)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
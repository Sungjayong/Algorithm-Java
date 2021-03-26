//13706번. 제곱근
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());
        BigInteger sqrt = n.sqrt();

        System.out.println(sqrt);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
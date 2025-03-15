import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean [] isPrime = new boolean[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 1001; i++) {
            isPrime[i] = true;
        }

        Integer N = Integer.valueOf(br.readLine());
        String[] numbers = br.readLine().split(" ");
        int count = 0;
        checkPrime();


        for (String x : numbers) {
            if (isPrime[Integer.parseInt(x)]) {
                count++;
            }
        }
        System.out.println(count);

    }

    public static void checkPrime() {
        int n = 1000;
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < (int) Math.sqrt(n)+1; i++) {
            int j = 2;
            while (i * j <= n) {
                isPrime[i * j] = false;
                j++;
            }
        }
    }


}
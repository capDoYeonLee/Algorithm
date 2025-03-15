import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isPrime; //= new boolean[number + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer number = Integer.valueOf(br.readLine());
        for (int t = 0; t < number; t++) {
            Integer x = Integer.valueOf(br.readLine());
            isPrime = new boolean[x + 1];
            for (int a = 0; a <= x; a++) {
                isPrime[a] = true;
            }
            checkPrime(x);
            int max = 0;
            for (int i = 2; i <= x / 2; i++) {
                if (isPrime[i] && isPrime[x - i]) {
                    max= i;
                }
            }
            System.out.println(max + " " + (x - max));
        }
    }

    public static void checkPrime(int x) {
        for (int i = 2; i < (int) Math.sqrt(x) + 1; i++) {
            int j = 2;
            while (i * j <= x) {
                isPrime[i * j] = false;
                j++;
            }
        }
    }
}
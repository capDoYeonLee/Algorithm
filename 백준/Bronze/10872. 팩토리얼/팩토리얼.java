import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean [] confirm = new boolean[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.valueOf(br.readLine());
        System.out.println(factorial(N));

    }

    public static Integer factorial(int x) {
        if (x == 0) {
            return 1;
        }
        return factorial(x-1) * x;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(reader.readLine());

        int[] wine = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(reader.readLine());
        }


        dp[1] = wine[1];
        if (N > 1) {
            dp[2] = wine[1] + wine[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], wine[i] + wine[i - 1] + dp[i - 3]));
        }

        System.out.println(dp[N]);
    }

}

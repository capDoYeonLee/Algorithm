import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    static int T;
    static int W;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] test = br.readLine().split(" ");
        T = Integer.parseInt(test[0]);
        W = Integer.parseInt(test[1]);

        dp = new int[T + 1][3][W + 1];
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            dp[1][1][0] = 1;
            dp[1][2][1] = 0;
        } else if (n == 2) {
            dp[1][1][0] = 0;
            dp[1][2][1] = 1;
        }

        for (int t = 2; t <= T; t++) {
            n = Integer.parseInt(br.readLine());

            if (n == 1) {
                // w=0 미리 깔고 들어가고
                dp[t][1][0] = dp[t - 1][1][0] + 1;
                dp[t][2][0] = dp[t - 1][2][0];

                // w = 1 ~ w까지 돌리는거 저장
                for (int w = 1; w <= W; w++) {
                    dp[t][1][w] = Math.max(dp[t - 1][1][w], dp[t - 1][2][w - 1]) + 1;
                    dp[t][2][w] = Math.max(dp[t - 1][1][w - 1], dp[t - 1][2][w]);
                }
            }
            if (n == 2) {
                dp[t][1][0] = dp[t - 1][1][0];
                dp[t][2][0] = dp[t - 1][2][0] + 1;

                for (int w = 1; w <= W; w++) {
                    dp[t][1][w] = Math.max(dp[t - 1][1][w], dp[t - 1][2][w - 1]);
                    dp[t][2][w] = Math.max(dp[t - 1][1][w - 1], dp[t - 1][2][w]) + 1;
                }
            }
        }

        int max = 0;
        for (int w = 0; w <= W; w++) {
            max = Math.max(max, Math.max(dp[T][1][w], dp[T][2][w]));
        }
        System.out.println(max);
    }
}

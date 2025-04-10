import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        jump();
    }

    public static void jump() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if(dp[i][j] == 0) continue;

                if(i == N-1 && j == N-1) {
                    break;
                }

                int tmp = board[i][j];

                if(board[i][j]+i < N){
                    dp[tmp+i][j] += dp[i][j];
                }

                if(board[i][j]+j < N){
                    dp[i][tmp+j] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
}

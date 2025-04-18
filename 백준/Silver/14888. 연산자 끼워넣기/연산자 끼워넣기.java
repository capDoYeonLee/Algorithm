import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int[] operator;
    static int N;
    static int maxSum = Integer.MIN_VALUE;
    static int minSum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        operator = new int[4];
        arr = new int[N];

        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(arr[0], 1);
        System.out.println(maxSum);
        System.out.println(minSum);

    }

    public static void dfs(int num, int idx) {

        if (idx == N) {
            maxSum = Math.max(maxSum, num);
            minSum = Math.min(minSum, num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(num + arr[idx], idx + 1);
                        break;
                    case 1:
                        dfs(num - arr[idx], idx + 1);
                        break;
                    case 2:
                        dfs(num * arr[idx], idx + 1);
                        break;
                    case 3:
                        dfs(num / arr[idx], idx + 1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}

















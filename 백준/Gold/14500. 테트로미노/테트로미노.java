import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, maxSum = 0;
    static int[][] grid;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer tt = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(tt.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, grid[i][j]);
                visited[i][j] = false;

                // T자 모양 체크
                checkTShape(i, j);
            }
        }
        System.out.println(maxSum);
    }

    public static void dfs(int x, int y, int depth, int total) {
        if (depth == 4) {
            maxSum = Math.max(maxSum, total);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 여기에서 ny의 범위를 N이 아니라 M으로 변경해야 함
            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                continue;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, total + grid[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    static void checkTShape(int x, int y) {
        int[][] tShapes = {
                {0, -1, 0, 1, 1, 0},  // ㅗ
                {0, -1, 0, 1, -1, 0}, // ㅜ
                {-1, 0, 1, 0, 0, 1},  // ㅏ
                {-1, 0, 1, 0, 0, -1}  // ㅓ
        };

        for (int[] shape : tShapes) {
            int sum = grid[x][y];
            boolean valid = true;

            for (int i = 0; i < 3; i++) {
                int nx = x + shape[i * 2];
                int ny = y + shape[i * 2 + 1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    valid = false;
                    break;
                }
                sum += grid[nx][ny];
            }

            if (valid) {
                maxSum = Math.max(maxSum, sum);
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] iceberg;
    static int r, c;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tt = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(tt.nextToken());
        c = Integer.parseInt(tt.nextToken());

        iceberg = new int[r][c];

        for (int i = 0; i < r; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            year++;
            meltIce();

            visit = new boolean[r][c];
            int count = countIce();

            if (count >= 2) {
                System.out.println(year);
                return;
            }
            if (count == 0) {
                System.out.println(0);
                return;
            }
        }
    }


    public static void meltIce() {
        int[][] temp = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (iceberg[i][j] > 0) {
                    int seaCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int x = i + dx[d];
                        int y = j + dy[d];
                        if (x >= 0 && x < r && y >= 0 && y < c && iceberg[x][y] == 0) {
                            seaCount++;
                        }
                    }
                    temp[i][j] = Math.max(iceberg[i][j] - seaCount, 0);
                }
            }
        }

        iceberg = temp;
    }


    public static int countIce() {
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (iceberg[i][j] > 0 && !visit[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }


    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            for (int d = 0; d < 4; d++) {  
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visit[nx][ny] && iceberg[nx][ny] > 0) {
                    q.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }
        }
    }
}

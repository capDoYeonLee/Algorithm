import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int[][] graph;
    static int[][] dist;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); 
        graph = new int[N][N];
        dist = new int[N][N];

        
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = tmp.charAt(j) - '0'; 
                dist[i][j] = Integer.MAX_VALUE; 
            }
        }
        
        dijkstra();
        System.out.println(dist[N - 1][N - 1]);
    }

    public static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); 
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int count = cur[0];
            int y = cur[1];
            int x = cur[2];
            
            if (y == N - 1 && x == N - 1) return;
            
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int newCount = count + (graph[ny][nx] == 0 ? 1 : 0);
                    if (dist[ny][nx] > newCount) {
                        dist[ny][nx] = newCount;
                        pq.offer(new int[]{newCount, ny, nx});
                    }
                }
            }
        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, startCity, destinationCity;
    static ArrayList<ArrayList<int[]>> city = new ArrayList<>();
    static int[] cost;
    static PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // (비용, 노드) 우선순위 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            city.add(new ArrayList<>());
        }

        cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            city.get(s).add(new int[]{d, c});
        }

        st = new StringTokenizer(br.readLine(), " ");
        startCity = Integer.parseInt(st.nextToken());
        destinationCity = Integer.parseInt(st.nextToken());

        dijkstra(startCity);
        System.out.println(cost[destinationCity]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // (비용, 노드)
        q.offer(new int[]{0, start}); 
        cost[start] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowCost = now[0];
            int node = now[1];

            if (cost[node] < nowCost) continue;

            for (int[] info : city.get(node)) {
                int destination = info[0];
                int goCost = info[1];

                if (cost[destination] > cost[node] + goCost) {
                    cost[destination] = cost[node] + goCost;
                    q.offer(new int[]{cost[destination], destination});
                }
            }
        }
    }
}

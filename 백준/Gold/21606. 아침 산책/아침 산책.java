import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] A;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        String line = br.readLine();
        for (int i = 1; i <= N; i++) {
            A[i] = line.charAt(i - 1) - '0';
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        long result = 0;

        for (int i = 1; i <= N; i++) {
            if (A[i] == 1) {
                for (int neighbor : graph[i]) {
                    if (A[neighbor] == 1) {
                        result++;
                    }
                }
            }
        }
        result /= 2; 

        Arrays.fill(visited, false);
        for (int i = 1; i <= N; i++) {
            if (A[i] == 0 && !visited[i]) {
                int indoorCount = dfs(i);
                result += (long) indoorCount * (indoorCount - 1);
            }
        }

        System.out.println(result);
    }

    public static int dfs(int node) {
        visited[node] = true;
        int indoorCount = 0;

        for (int neighbor : graph[node]) {
            if (A[neighbor] == 1) {
                indoorCount++;
            } else if (!visited[neighbor]) {
                indoorCount += dfs(neighbor);
            }
        }
        return indoorCount;
    }
}

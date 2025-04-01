import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int N, M;
    static boolean[] visit;
    static List<List<Integer>> heavier;
    static List<List<Integer>> lighter;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tt = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tt.nextToken());
        M = Integer.parseInt(tt.nextToken());

        heavier = new ArrayList<>();
        lighter = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            heavier.add(new ArrayList<>());
            lighter.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());

            heavier.get(small).add(big);
            lighter.get(big).add(small);  
        }

        int c = 0;
        int threshold = N / 2;

        for (int i = 1; i <= N; i++) {
            if (countBig(i) > threshold || countSmall(i) > threshold) {
                c++;
            }
        }
        System.out.println(c);
    }

    public static int countSmall(int start) {
        visit = new boolean[N + 1];
        return dfs(start, lighter);
    }

    public static int countBig(int start) {
        visit = new boolean[N + 1];
        return dfs(start, heavier);
    }

    public static int dfs(int node, List<List<Integer>> graph) {
        visit[node] = true;
        int count = 0;

        for (int next : graph.get(node)) {
            if (!visit[next]) {
                count += 1 + dfs(next, graph);
            }
        }
        return count;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();
    static int V, E;
    static int [] color;
    static String answer;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            answer = "YES";
            check = new boolean[V + 1];
            arr = new ArrayList<>();
            for (int i = 1; i <= V+1; i++) {
                arr.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                StringTokenizer tt = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(tt.nextToken());
                int y = Integer.parseInt(tt.nextToken());
                arr.get(x).add(y);
                arr.get(y).add(x);
            }
            color = new int[V + 1];
            for (int i = 0; i <= V; i++) {
                if (color[i] == 0) {
                    if (!bfs(i)) {
                        break;
                    }
                }
            }
            System.out.println(answer);

        }
    }

    
    public static boolean bfs(int node) {
        Deque<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i : arr.get(now)) {
                if (color[now] == color[i]) {
                    answer = "NO";
                    return false;
                }
                if (color[i] == 0) {
                    color[i] = color[now] * -1;
                    q.add(i);
                }
            }
        }
        return true;
    }
}


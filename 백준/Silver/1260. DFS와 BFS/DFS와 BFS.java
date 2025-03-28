import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sbb = new StringBuilder();
    private static StringTokenizer st;
    static int node, line;
    static boolean[] checkDFS;
    static boolean[] checkBFS;
    static int[][] arr;
    static Deque<Integer> q;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        arr = new int[node + 1][node + 1];
        q = new ArrayDeque<>();
        checkBFS = new boolean[node + 1];
        checkDFS = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer tt = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tt.nextToken());
            int b = Integer.parseInt(tt.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(V);
        System.out.println(sb);
        sb.append("\n");
        bfs(V);

        System.out.println(sbb);
    }

    public static void dfs(int depth) {
        sb.append(depth + " ");
        checkDFS[depth] = true;
        for (int i = 0; i <= node; i++) {
            if (arr[depth][i] == 1 && !checkDFS[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        q.offer(start);
        checkBFS[start] =true;

        while (!q.isEmpty()) {
            int tmp = q.poll();
            sbb.append(tmp + " ");
            for (int i = 1; i <= node; i++) {
                if (arr[tmp][i] == 1 && !checkBFS[i]) {
                    q.offer(i);
                    checkBFS[i] = true;
                }
            }
        }

    }


}
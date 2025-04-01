import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.IntFunction;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K, X;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static StringTokenizer st;
    static ArrayList<Integer> result = new ArrayList<>();
    static HashMap<Integer, Integer> min = new HashMap<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer tt = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tt.nextToken());
        M = Integer.parseInt(tt.nextToken());
        K = Integer.parseInt(tt.nextToken());
        X = Integer.parseInt(tt.nextToken());

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            //arr.get(b).add(a);
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(X);
        dist[X] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (dist[cur] > K) {
                break;
            }
            if (dist[cur] == K) {
                result.add(cur);
            }

            for (int next : arr.get(cur)) {
                if (dist[next] != -1) {
                    continue;
                }
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }

        Collections.sort(result);
        if (result.isEmpty()) {
            System.out.println("-1");
        }else {
            for (int x : result) {
                System.out.println(x);
            }    
        }
        
    }
}

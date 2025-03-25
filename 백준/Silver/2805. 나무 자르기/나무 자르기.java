import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] tree = new int[n];
        int min = 0;
        int max = 0;

        StringTokenizer tt = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(tt.nextToken());
            if (max < tree[i]) {
                max = tree[i];
            }
        }

        while (min < max) {
            int mid = (min + max) /2;
            long sum = 0;
            for (int treeHeight : tree) {
                if (treeHeight - mid > 0) {
                    sum += (treeHeight - mid);
                }
            }

            if (sum < m) {
                max = mid;
            }

            else {
                min = mid + 1;
            }
        }
        System.out.println(min -1);

    }
}
import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int [] check = new int[n];
        HashSet<Integer> find = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            find.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer tt = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            if (find.contains(Integer.parseInt(tt.nextToken()))){
                bw.write(1 + "\n");
            }else {
                bw.write(0 + "\n");
            }
        }
        bw.flush();
        bw.close();

    }
}
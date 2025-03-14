import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Integer x  = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        String[] arr = br.readLine().split(" ");
        List<String> result = new ArrayList<>();

        for (String y : arr) {
            if (Integer.parseInt(y) < X) {
                result.add(y);
            }
        }

        for (String z : result) {
            System.out.print(z);
            System.out.print(" ");
        }

    }
}

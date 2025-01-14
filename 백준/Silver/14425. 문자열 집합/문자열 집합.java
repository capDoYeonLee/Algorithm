import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<String> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer n = Integer.parseInt(st.nextToken());
        Integer m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String textSet = br.readLine();
            arr.add(textSet);
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            if ( arr.contains(br.readLine())){
                count += 1;
            }
        }
        System.out.println(count);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer x  = Integer.valueOf(br.readLine());


        for (int i = 0; i < x; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer a = Integer.valueOf(st.nextToken());
            String b = st.nextToken();
            for (int j = 0; j < b.length(); j++) {
                for (int t = 0; t < a; t++) {
                    System.out.print(b.charAt(j));
                }
            }
            System.out.println("");
        }


    }
}
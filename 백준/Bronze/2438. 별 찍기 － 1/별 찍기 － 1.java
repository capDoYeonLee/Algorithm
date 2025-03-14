import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer x  = Integer.valueOf(br.readLine());

        for (int i = 0; i < x; i++) {
            for (int j = 1; j <= i + 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

    }
}

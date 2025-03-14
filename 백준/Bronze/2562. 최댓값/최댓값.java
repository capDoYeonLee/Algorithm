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

        Integer max = 0;
        int max_index = 0;
        for (int i = 0; i < 9; i++) {
            int r = Integer.valueOf(br.readLine());
            if (r > max) {
                max = r;
                max_index = i+1;
            }
        }
        System.out.println(max);
        System.out.println(max_index);


    }
}

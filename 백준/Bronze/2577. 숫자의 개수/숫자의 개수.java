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
        Integer y  = Integer.valueOf(br.readLine());
        Integer z  = Integer.valueOf(br.readLine());

        int result = x * y * z;
        String text = String.valueOf(result);
        for (int i = 0; i < 10; i++) {
            int count = 0;
            for (int j = 0; j < text.length(); j++) {
                if (Integer.parseInt(String.valueOf(text.charAt(j))) == i){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

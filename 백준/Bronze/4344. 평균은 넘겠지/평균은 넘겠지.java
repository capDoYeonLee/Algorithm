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
            String [] arr = br.readLine().split(" ");
            int sum = 0;
            for (int j = 1; j <= Integer.parseInt(arr[0]); j++) {
                sum += Integer.parseInt(arr[j]);
            }
            double leverage = sum / Integer.parseInt(arr[0]);

            int count = 0;
            for (int j = 1; j <= Integer.parseInt(arr[0]); j++) {
                if (leverage < Integer.parseInt(arr[j])) {
                    count++;
                }
            }
            System.out.printf("%.3f%%\n", count / Double.parseDouble(arr[0]) * 100);

        }
    }
}

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
            int task = 1;
            int result = 0;
            String problem = br.readLine();
            for (int j = 0; j < problem.length(); j++) {
                char c = problem.charAt(j);
                if (c == 'O'){
                    result += task;
                    task++;
                } else if (c == 'X') {
                    task =  1;
                }
            }
            System.out.println(result);
        }
    }
}

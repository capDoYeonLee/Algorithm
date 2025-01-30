import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer T = Integer.parseInt(br.readLine());



        for (int i = 0; i < T; i++) {
            Integer N = Integer.valueOf(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long max = 0;
            long result = 0;

            int length = arr.length -1;

            for (int j = length; j >= 0; j--) {
                if (max < arr[j]) {
                    max = arr[j];
                } else {
                    result += max - arr[j];
                }
            }
            System.out.println(result);


        }

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Integer N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }
        int sum = 0;

        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                sum += (arr[i] - arr[i+1] +1);
                arr[i] = arr[i + 1] - 1;
            }
        }
        System.out.println(sum);

    }
}



















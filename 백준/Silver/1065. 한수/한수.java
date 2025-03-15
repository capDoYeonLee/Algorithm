import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean [] confirm = new boolean[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.valueOf(br.readLine());

        for (int i = 0; i < 100; i++) {
            confirm[i] = true;
        }

        for (int i = 100; i <= 1000; i++) {
            for (int j = 0; j < 1; j++) {
                String text = String.valueOf(i);
                int a = text.charAt(j+1) - text.charAt(j);
                int b = text.charAt(j+2) - text.charAt(j+1);
                if (a == b) {
                    confirm[i] = true;
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (confirm[i]) {
                count++;
            }
        }
        System.out.println(count);



    }
}
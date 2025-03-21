import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.valueOf(br.readLine());
        Integer sum  = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int x = Integer.valueOf(br.readLine());
            if (x == 0) {
                if (stack.size() != 0) {
                    stack.pop();
                }
            }
            if (x != 0) {
                stack.push(x);
            }
        }
        int length = stack.size();
        for (int i = 0; i < length; i++) {
            sum += stack.peek();
            stack.pop();
        }

        System.out.println(sum);
    }

}
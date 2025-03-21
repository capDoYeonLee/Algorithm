import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 테스트 케이스 개수
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            stack.push(Integer.valueOf(br.readLine()));
        }
        int x = stack.peek();
        int count = 1;
        for (int i = 0; i < N; i++){
            if (stack.peek() <= x){
                stack.pop();
                continue;
            }
            if (stack.peek() > x) {
                count++;
                x = stack.peek();
                stack.pop();
            }
        }
        System.out.println(count);

    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력 최적화

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            queue.pop();
            int last = queue.peek();
            queue.offer(last);
            queue.pop();
        }
        bw.write(queue.peek() + "\n");

        bw.flush(); 
        bw.close();
    }
}

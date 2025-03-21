import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.valueOf(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String [] arr = br.readLine().split(" ");

            if (arr[0].equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek()); // 마지막 값을 확인하고 제거하지는 않는다.
                }
            }
            if (arr[0].equals("size")) {
                System.out.println(stack.size());
            }
            if (arr[0].equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
            if (arr[0].equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(stack.peek());
                    stack.pop();
                }
            }

            if (arr[0].equals("push")) {
                stack.push(Integer.valueOf(arr[1]));
            }
        }


    }
}
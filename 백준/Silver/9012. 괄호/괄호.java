import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        for (int i = 0; i < N; i++) {
            String x = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();  // 스택을 한 번만 선언하고 사용
            boolean isValid = true;  // 올바른 괄호 문자열인지 판별

            for (int t = 0; t < x.length(); t++) {
                char c = x.charAt(t);

                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty()) {  // 스택이 비어 있으면 올바른 괄호 문자열이 아님
                        isValid = false;
                        break;  // 반복 종료
                    } else {
                        stack.pop();
                    }
                }
            }

            // 괄호 검사 후 스택이 비어있어야 YES (올바른 VPS)
            if (isValid && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String text = br.readLine();
        String bomb = br.readLine();
        Integer bombLength = bomb.length();

        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));

            if (stack.size() >= bombLength) {
                boolean flag = true;

                for (int j = 0; j < bombLength; j++) {
                    if (stack.get(stack.size() - bombLength + j) != bomb.charAt(j)) {
                        flag =false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < bombLength; j++) {
                        stack.pop();
                    }
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : stack) {
            sb.append(c);
        }
        System.out.println(sb.length()==0? "FRULA" : sb.toString());
    }
}
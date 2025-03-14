import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken();
        String b = st.nextToken();
        int x = parse(a);
        int y = parse(b);
        if (x > y) {
            System.out.println(x);
        } else {
            System.out.println(y);
        } 
        
    }

    public static int parse(String text) {
        int x = Integer.parseInt(text);
        int one = x % 10 * 100;
        int ten = x % 100 / 10 * 10;
        int hun = x / 100;
        return one + ten + hun;
        
    }
}
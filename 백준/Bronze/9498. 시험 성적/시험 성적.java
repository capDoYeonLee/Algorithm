import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer x = Integer.valueOf(br.readLine());

        if ((100 >= x) && (90 <= x)) {
            System.out.println("A");
        } else if ((89 >= x) && (80 <= x)) {
            System.out.println("B");
        } else if ((79 >= x) && (70 <= x)) {
            System.out.println("C");
        } else if ((69 >= x) && (60 <= x)) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
        
    }
}

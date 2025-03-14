import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer x = Integer.valueOf(br.readLine());
        Integer y = Integer.valueOf(br.readLine());

        int one = y % 10;
        int ten = y % 100 / 10;
        int hun = y / 100;

        System.out.println(x * one);
        System.out.println(x * ten);
        System.out.println(x * hun);
        System.out.println(x * y);
    }
}

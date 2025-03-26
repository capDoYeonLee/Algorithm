import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Integer mul =1;
    private static long c;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.println(pow(a,b));


    }

    public static long pow(long a, long exponent) {
        if (exponent == 1) {
            return a%c;
        }
        long tmp = pow(a, exponent / 2);
        if (exponent % 2 != 0) {
            return (tmp * tmp % c) * a %c;
        }
        return tmp * tmp %c;
    }
}
import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int N;
    static int[] num, permutation;
    static  boolean[] check;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = x-y;
        bw.write(z+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
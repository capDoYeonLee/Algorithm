import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int ten = N/10;
        int one = N%10;
        int newThing = (ten+one)%10;
        int updateThing = one * 10 + newThing;
        int count = 1;

        while ((updateThing != N) && (count != 100)) {
            ten = updateThing/10;
            one = updateThing%10;
            newThing = (ten+one)%10;
            updateThing= one * 10 + newThing;
            count++;
        }
        System.out.println(count);
    }
}
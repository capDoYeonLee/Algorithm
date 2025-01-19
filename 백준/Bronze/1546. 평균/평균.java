import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static int max = 0;

    public static void main(String[] args) throws IOException {
        List<Double> original = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        List<Integer> arr = Arrays.stream(br.readLine().split(" "))
                .map(x -> Integer.parseInt(x)).collect(Collectors.toList());

        for (int x : arr) {
            if (x > max) {
                max = x;
            }
        }

        original = arr.stream().map(
                x -> convert(x)
        ).collect(Collectors.toList());

        Double aver = 0.d;
        for (Double x : original) {
            aver += x;
        }
        System.out.println(aver/N);
    }

    public static Double convert(int x) {
        return x * 100.d / max;
    }


}

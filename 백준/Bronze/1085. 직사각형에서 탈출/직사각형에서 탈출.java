import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] arr = br.readLine().split(" ");
        
        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);
        int w = Integer.parseInt(arr[2]);
        int h = Integer.parseInt(arr[3]);
        
        int x_min = x - 0;
        int y_min = y - 0;
        
        if (x_min > w - x){
            x_min = w -x;
        }
        if (y_min > h - y) {
            y_min = h - y;
        }

        if (x_min > y_min) {
            System.out.println(y_min);
        } else {
            System.out.println(x_min);
        }
        

    }
}

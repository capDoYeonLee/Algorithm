import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalNumber = Integer.parseInt(st.nextToken());
        int groupNumber = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        ArrayList<Integer> people = new ArrayList<>();
        ArrayList<Integer> height = new ArrayList<>();
        int answer = 0;
        //키 입력받기
        for (int i = 0; i < totalNumber; i++) {
            height.add(Integer.parseInt(st2.nextToken()));
        }
        //키 차이 구하기
        for (int i = 0; i < totalNumber - 1; i++) {
            people.add(height.get(i + 1) - height.get(i));
        }
        //키 차이 오름차순 정렬
        Collections.sort(people);

        //가장 큰 키차이를 K-1개 제외하고 나머지들 더함
        for (int i = 0; i < totalNumber - groupNumber; i++) {
            answer += people.get(i);
        }
        System.out.println(answer);
    }
}

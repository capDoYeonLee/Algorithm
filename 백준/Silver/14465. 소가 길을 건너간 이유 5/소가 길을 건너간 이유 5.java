import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 신호등 개수
        int k = Integer.parseInt(st.nextToken()); // 연속되어야 하는 신호등 개수
        int b = Integer.parseInt(st.nextToken()); // 고장난 신호등 개수

        // 고장난 신호등 위치 저장
        boolean[] broken = new boolean[n + 1];
        for (int i = 0; i < b; i++) {
            int x = Integer.parseInt(br.readLine());
            broken[x] = true; // 고장난 신호등은 true로 설정
        }

        // 초기 구간에서 고장난 신호등 개수 세기
        int brokenCount = 0;
        for (int i = 1; i <= k; i++) {
            if (broken[i]) {
                brokenCount++;
            }
        }

        // 최소 고장난 신호등 개수 저장
        int minFixes = brokenCount;

        // 슬라이딩 윈도우로 구간을 옮기며 최소 고장난 신호등 개수 찾기
        for (int i = k + 1; i <= n; i++) {
            if (broken[i - k]) {
                brokenCount--; // 앞쪽 구간 제거
            }
            if (broken[i]) {
                brokenCount++; // 새로운 구간 추가
            }
            minFixes = Math.min(minFixes, brokenCount);
        }

        System.out.println(minFixes);
    }
}

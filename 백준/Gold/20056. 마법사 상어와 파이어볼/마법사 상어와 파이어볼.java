import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class FireBall{
    int r,c,m,s,d;

    public FireBall(int r, int c, int m, int s, int d) {
        this.r = r;
        this.c = c;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

public class Main {

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};	
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};	
    static ArrayList<FireBall>[][] map;
    static ArrayList<FireBall> fireBalls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                map[i][j] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireBalls.add(new FireBall(r, c, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            meteorMove(N);
            meteorFire(N);
        }
        int result = meteorCal();
        System.out.println(result);
    }

    static void meteorMove(int N) {
        for (FireBall cur : fireBalls) {
            int tempR = (cur.r + N + dr[cur.d] * (cur.s%N)) % N;
            int tempC = (cur.c + N + dc[cur.d] * (cur.s%N)) % N;
            cur.r = tempR;
            cur.c = tempC;
            map[cur.r][cur.c].add(cur);
        }
    }
    
    static void meteorFire(int N){
        for(int r = 0; r<N;r++){
            for(int c = 0; c<N;c++) {
                //파이어볼 개수가 2개 미만일 때
                if(map[r][c].size() < 2){
                    map[r][c].clear();
                    continue;
                }
                //파이어볼 2개 이상일 때
                int mSum = 0, sSum = 0, oddCount = 0, evenCount = 0;
                int size = map[r][c].size();
                //분열 진행!
                for(FireBall cur : map[r][c]){
                    mSum += cur.m;	
                    sSum += cur.s;	
                    if(cur.d % 2 == 1)
                        oddCount++;
                    else		
                        evenCount++;
                    fireBalls.remove(cur);	
                }
                map[r][c].clear();
                mSum /= 5;	
                if(mSum == 0)	
                    continue;
                sSum /= size;	
                
                if(oddCount == size || evenCount == size){
                    for(int i=0;i<8;i+=2)	
                        fireBalls.add(new FireBall(r,c,mSum, sSum, i));
                }else{
                    for(int i=1;i<8;i+=2)	
                        fireBalls.add(new FireBall(r,c,mSum, sSum, i));
                }
            }
        }
    }
    
    static int meteorCal(){
        int result = 0;
        for(FireBall cur : fireBalls)
            result += cur.m;
        return result;
    }
}


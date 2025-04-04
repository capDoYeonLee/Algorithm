import java.io.*;
import java.util.*;
public class Main {
    public static int N;
    public static int[] cur;	//현재 순열의 값 저장 배열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedReader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과값 출력하는 BufferedWriter
        //-------입력값 저장 및 배열 초기화---------
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        cur = new int[N];
        for(int i=0;i<N;i++) {
            cur[i] = Integer.parseInt(st.nextToken());
        }
        if(nextPermutation()) {		//다음 순열이 존재하는지 확인
            for(int i=0;i<N;i++) {
                bw.write(cur[i] + " ");	//다음 순열 BufferedWriter 저장
            }
        }
        else
            bw.write("-1");	//다음 순열 존재 안할 시 -1 BufferedWriter 저장
        bw.flush();		//결과 저장
        bw.close();
        br.close();
    }
    //-----next_permutation 알고리즘 함수-------
    public static boolean nextPermutation() {
        int point = -1;
        for(int i=N-1;i>0;i--) {		//과정 1.
            if(cur[i-1]<cur[i]) {
                point = i;
                break;
            }
        }
        if(point==-1)	//과정 1. 순서쌍 찾지 못하면 다음 순열 존재 X
            return false;

        int change = -1;
        for(int i=N-1;i>=point;i--) {	//과정 2.
            if(cur[point-1]<=cur[i]) {
                change=i;
                break;
            }
        }
        swap(point-1, change);	//과정 3.

        change = N-1;
        while(point<change) {	//과정 4.
            swap(point,change);
            point++;
            change--;
        }
        return true;		//다음 순열 존재 반환
    }
    //-------배열의 값 변경하는 함수------
    public static void swap(int x, int y) {
        int temp = cur[x];
        cur[x] = cur[y];
        cur[y] = temp;
        return;
    }
}
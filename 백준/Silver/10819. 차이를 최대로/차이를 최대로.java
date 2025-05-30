import java.io.*;
import java.util.*;
public class Main{
	public static int N;	//입력되는 숫자의 개수
	public static int[] num,permutation;	//N개의 입력된 숫자, 순열 값 저장
	public static boolean[] check;		//N개의 숫자 사용되었는지 확인 배열
	public static int max = Integer.MIN_VALUE;		//차이 절대값의 최대합
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedReader
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과값 출력하는 BufferedWriter
        //---------입력값 저장 및 배열 초기화---------
    	N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	num = new int[N];
    	permutation = new int[N];
    	check = new boolean[N];
    	for(int i=0;i<N;i++) {
    		num[i] = Integer.parseInt(st.nextToken());
    	}
        //순열 첫 번째 값 저장 후 함수 실행
        /*
        이유는 처음이 [1]-[0]을 진행해야 하는데
        함수에 순열에 처음 들어가는 수의 인덱스가 [0]이면
        [0] - [-1]로 ArrayIndexBound 에러가 발생하기 때문에
        첫 번째 순열 값은 저장하고 함수를 실행하였습니다.
        */
    	for(int i=0;i<N;i++) {
    		check[i] = true;
    		permutation[0] = num[i];
    		maxDif(1, 0);
    		check[i] = false;
    	}
    	bw.write(max + "\n");		//차이 절대값의 최대합 BufferedWriter 저장
    	bw.flush();		//결과 출력
    	bw.close();
    	br.close();
    }
    //-----순열의 차이 절대값의 최대합 구하는 함수---------
    public static void maxDif(int length, int cur) {
    	if(length==N) {		//순열 완성시
    		max = Math.max(max, cur);		//최대값 비교
    		return;
    	}
        //-------순열의 들어갈 숫자 탐색-------
    	for(int i=0;i<N;i++) {
    		if(!check[i]) {
    			check[i] = true;
    			permutation[length] = num[i];
                	//차이 절대값 합 구하는 과정
    			int temp = Math.abs(permutation[length-1] - permutation[length]);
    			maxDif(length+1, cur+temp);		//재귀 발생
    			check[i] = false;
    		}
    	}
    	return;
    }
}


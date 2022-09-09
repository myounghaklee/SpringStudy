import java.util.Arrays;
import java.util.Scanner;

public class boj2309_일곱난쟁이 {
    private static int input[];
    private static int[] answer;

    /**
    내가 생각하는 알고리즘 flow
    1. 9개의 입력중 7개를 뽑음 -> 조합? : 완탐
    2. 7개의 합이 100인경우를 찾으면됨 : 기저조건
     
     - 사소한 정의들
     1. input 배열은 글로벌로 : 그래야 콤비네이션 함수에서 사용 가능 
    시간제한 2초 이기 때문에 걍 scanner사용

     여기까지가 기본적인 조합임
     -> 그럼 조합을 어떻게 구현할까? 에 대한 답이 필요함
     1. 재귀
     2. for문
     3. 백트래킹
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input = new int [9];
        answer = new int [7];
        for(int i = 0; i<9; i++){
            input[i] = sc.nextInt();
        }
        
        combi(0,0);
        Arrays.sort(answer);
        System.out.println(answer.toString());
            
    }

    private static void combi(int i, int i1) {
    }
}

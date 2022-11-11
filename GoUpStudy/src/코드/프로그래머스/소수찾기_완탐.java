package 코드.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 소수찾기_완탐 {
    /*
    Idea :
    1. 문자열 -> int 전환
    2. 순열로 모든경우의수 탐색
    3. 기저조건에서 소수인지 판단
     */

    public static void main(String[] args) {
        System.out.println(solution("17"));

    }

    public static int solution(String numbers) {
        int answer = 0;
        List<Integer> permutations = new ArrayList<>();

        // 순열을 위한 데이터 세팅(String -> int array)
        char [] charArry = numbers.toCharArray();
        int [] arry = new int[charArry.length];
        boolean isVisited[] = new boolean[arry.length];
        for(int i =0 ;i< charArry.length; i++){
            arry[i] = Integer.parseInt(String.valueOf(charArry[i]));
        }
        for(int i = 1; i>arry.length; i++){
            permu();

        }

        for(int i : permutations){
            if(isPrime(i)) answer++;
            //isVisited 초기화 한번에 어떻게 하지/

        }

        return answer;
    }

    private static void permu() {
    }

    //순열 만들기


    //소수 체크
    public static boolean isPrime(int n){
        if(n<2) return false;
        for(int i =3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
}

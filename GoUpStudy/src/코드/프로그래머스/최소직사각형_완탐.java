package 코드.프로그래머스;

public class 최소직사각형_완탐 {
    public static void main(String[] args) {

        int sizes [][] = {{60,50}, {30,70}, {60,30}, {80,40}};

        int ans = solution(sizes);
    }


    public static int solution(int[][] sizes) {
        int seroMax = Integer.MIN_VALUE;
        int garoMax = Integer.MIN_VALUE;
        for(int i =0; i< sizes.length; i++){
            seroMax = sizes[i][0]>seroMax ? sizes[i][0]: seroMax;
        }
        int answer = 0;
        return answer;
    }
}

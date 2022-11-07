package 코드.프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 모의고사_완탐 {
    public static void main(String[] args) {

        int [] answsers = {1,2,3,4,5};
        Integer [] ans= solution(answsers);
        System.out.println(ans[0]);
    }

    public static Integer[] solution(int[] answers) {

        int[] person1 = {1,2,3,4,5}; //이만큼씩 반복
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        int tmp[] = new int [3];

        //각각의 수포자들이 맞은 답의 수 구하기
        for(int i =0 ;i<answers.length; i ++){
            if(answers[i] == person1[i%5]) tmp[0]++;
            if(answers[i] == person2[i%8]) tmp[1]++;
            if(answers[i] == person3[i%10]) tmp[2]++;
        }

        //맞힌 답들 중 최고치 구하기
        int maxCnt = Math.max(tmp[0], Math.max(tmp[1], tmp[2]));

        //맞힌 답들과 같은 사람 ans에 더하기
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ;i<3; i++){
            if(maxCnt == tmp[i])list.add(i+1);
        }
        Integer[] answer = new Integer[list.size()];
        answer = list.toArray(new Integer[0]);

        return answer;
    }
}

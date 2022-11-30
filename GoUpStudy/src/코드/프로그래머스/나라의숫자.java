package 코드.프로그래머스;

public class 나라의숫자 {
    public static void main(String[] args) {
        String a = solution(3);
    }

    private static String solution(int n) {
        String[] num = {"4","1","2"};
        String answer = "";

        while(n > 0){
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }
}

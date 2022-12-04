package 코드.프로그래머스;

public class 완탐2xN타일링 {
    /*
    피보나치 -> DP로 접근하면됨
     */
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static int solution(int n) {
        int answer = 0;

        long [] dp = new long [n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i<n; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        return (int) (dp[n-1] % 1000000007L);
    }

}

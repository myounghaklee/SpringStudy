package 코드.프로그래머스;

public class 삼과칠_백준 {
    /**
     * 1. 문자열 to array
     * 2.
     * @param args
     */
    public static void main(String[] args) {


    }

    public int solution(int n){
        int ans =0;
        for(int i =1; i<=n; i++){
            //i에 3,7이 몇개나 있는지
            //int to String
            String s = Integer.toString(i);

            //O(n) = 수의 자리수 = nlog(n)
            for (char c : s.toCharArray()) {
                if(c == '3' || c=='7' )
                    ans ++;
            }
        }
        return ans;
    }

    public int solution2(int n){
        int ans =0;
        for(int i =1; i<=n; i++){
            //i에 3,7이 몇개나 있는지
            //int to String
            String s = Integer.toString(i);

            //O(n) = 수의 자리수 = nlog(n)
            for(int j = 0 ; j<s.length(); j++){
                char c = s.charAt(j);
                if(c == '3' || c=='7' )
                    ans ++;
            }
        }
        return ans;
    }
}

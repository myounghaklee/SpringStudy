package 구름;

import java.util.Scanner;

public class 문제3F_과유불급 {
    public static final Scanner scanner = new Scanner(System.in);


    /**
     *
     * @param n   카드의 수
     * @param m   앨범을 구매한 팬의 수
     * @param cards   각 카드에 적힌 숫자의 리스트 (cards[1] ~ card[n])
     * @param ranges  각 팬이 선택한 범위의 리스트 (ranges[0] ~ ranges[m-1])
     * @return        총 점수의 합이 가장 큰 범위 객체
     */
    public static Range getBestRange(int n, int m, int[] cards, Range[] ranges) {
        Range answer = ranges[0];


        return answer;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] cards = new int[n+1];
        Range[] ranges = new Range[m];

        // 각 카드의 정보를 입력받는다.
        for(int i = 1 ; i <= n ; i ++)
        {
            cards[i] = scanner.nextInt();
        }

        // 팬들의 정보를 입력받는다.
        for(int i = 0 ; i < m; i ++)
        {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            ranges[i] = new Range(i + 1, l, r);
        }

        //범위의 합이 가장 큰 범위를 계산한다.
        Range answer = getBestRange(n, m, cards, ranges);

        System.out.printf("%d %d\n", answer.index, answer.totalPoint);
    }

}

class Range{
    int index;
    int left;
    int right;
    long totalPoint;
    Range(int index, int left, int right)
    {
        this.index = index;
        this.left = left;
        this.right = right;
        this.totalPoint = 0;
    }
}

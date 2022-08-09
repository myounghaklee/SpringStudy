import java.util.*;

public class boj1158_요세푸스문제 {
    private static int N;
    private static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        Queue<Integer> dq = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            dq.add(i + 1);
        }
        System.out.print("<");
        while (!dq.isEmpty()) {
            for (int i = 0; i < K; i++) {
                if (i == K - 1) {
                    int tmp = dq.remove();
                    if (dq.size() == 0) {
                        System.out.print(tmp);
                    } else {
                        System.out.print(tmp + ", ");
                    }
                } else {
                    dq.add(dq.remove());
                }
            }
        }
        System.out.print(">");
    }
}

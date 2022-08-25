import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2178_미로 {
    private static int N;
    private static int M;
    private static int ANS = Integer.MAX_VALUE;

    public static class Point {
        int y;
        int x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int maze[][] = new int[N][M];
        boolean isVisited[][] = new boolean[N][M];

        //입력부
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = s.charAt(j) - '0';
            }
        }

        int tmp = bfs(0, 0, 1);
        ANS = ANS > tmp ? tmp : ANS;

        System.out.println(ANS);
    }

    private static int bfs(int y, int x, int cnt) {
        if (y == N - 1 && x == M - 1) {
            return cnt;
        }
    }

}

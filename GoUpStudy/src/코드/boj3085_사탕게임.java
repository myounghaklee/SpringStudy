package 코드;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj3085_사탕게임 {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        StringTokenizer st;
        //input setting
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j);
            }
        }

    }
}


import java.io.BufferedReader;import java.io.InputStreamReader;

public class Main {
    static int max = 1;
    static int N;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        // 행을 기준으로 오른쪽 색과 변경
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                search();
                swap(i, j + 1, i, j);
            }
        }
        // 열을 기준으로 아래쪽 색과 변경
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j);
                search();
                swap(i + 1, j, i, j);
            }
        }
        System.out.println(max);
        br.close();
    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    public static void search() {
        // 행에서 긴 수열 탐색
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }
        // 열에서 긴 수열 탐색
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 1;
                }
            }
        }
    }
}

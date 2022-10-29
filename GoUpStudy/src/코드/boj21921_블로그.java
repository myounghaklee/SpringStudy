package 코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj21921_블로그 {
    private static int N;
    private static int X;
    private static int input[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 일수
        X = Integer.parseInt(st.nextToken());//슬라이딩 윈도우 사이즈
        input = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i =0; i<N ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
    }
}

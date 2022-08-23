import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2178_미로 {
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int maze[][] = new int [N][M];
        boolean isVisited [][] = new boolean [N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j = 0 ;j<M ;j++){
                maze[i][j] = s.charAt(j)-'0';
            }
        }
    }

}

package 코드;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2941_크로아티아알파벳 {

    public static final String[] CROATIA_ALPHABET = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int count = 0;
        for (String alphabet : CROATIA_ALPHABET) {
            while (input.contains(alphabet)) {
                input = input.replaceFirst(alphabet, " "); // 크로아티아 알파벳을 공백으로 치환
                count++;
            }
        }

        input = input.replaceAll(" ", ""); // 공백 제거
        count += input.length(); // 남은 일반 알파벳 개수 추가

        System.out.println(count);
    }
}
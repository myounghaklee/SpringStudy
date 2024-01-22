package 코드;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class boj단어뒤집기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        boolean isTag = false;

        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (ch == '<') {
                // 태그 시작 전에 스택에 쌓인 문자 뒤집어서 추가
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                isTag = true;
                result.append(ch);
            } else if (ch == '>') {
                isTag = false;
                result.append(ch);
            } else if (isTag) {
                result.append(ch);
            } else {
                if (ch == ' ') {
                    // 공백 전에 스택에 쌓인 문자 뒤집어서 추가
                    while (!stack.isEmpty()) {
                        result.append(stack.pop());
                    }
                    result.append(ch);
                } else {
                    stack.push(ch);
                }
            }
        }

        // 남은 문자 뒤집어서 추가
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println(result.toString());
    }
}
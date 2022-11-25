package java8to18;

import java.util.function.Function;

public class Foo {
    public static void main(String[] args) {
        RunSomething runSomething = () -> System.out.println("hello");

        Function<Integer, Integer> plus10 = (i) -> i +10;
        System.out.println(plus10.apply(1));
    }
}
///////안녕하세요 이명학이라고 합니다. ㅋㅋㅋㅋ오 좋은데 개좋아 시발 이거 무어ㅑ 아 키돕
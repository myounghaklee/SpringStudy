import java.lang.reflect.Member;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<Member> consumer = t -> System.out.println(t.name + "은 " + t.company+ " 의 멤버다");
        consumer.accept(new Member("Enzo", "Maxst", 1));

        BiConsumer<Member, String> biConsumer = (t,u) ->{
            t.name = u;
            System.out.println("biConsumer 예제 : " +t.name );
        };
        biConsumer.accept(new Member(), "Mark");
    }
    static class Member{
        String name;
        String company;
        Integer id;
        public Member(String name, String company, int id){
            this.name = name;
            this.company = company;
            this.id = id;
        }
        public Member(){};
    }
}

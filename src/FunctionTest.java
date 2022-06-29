import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        Function<Integer, Boolean> function = t -> {
            if(t==1)return true;
            return false;
        };
        System.out.println(function.apply(1));
        System.out.println(function.apply(2));

        Member test1 = new Member("Enzo", "Maxst");
        Member test2 = new Member("Finn", "Maxst");

        BiFunction<Member, Member, Integer> biFunction = (t,u) ->{
          //  t = test1;
          //  u = test2;
            if(t.name == u.name)return 200;

            return (t.company == u.company)? 300:400;
        };
        //biFunction.apply(test1,test2);

        System.out.println(biFunction.apply(test1,test2));

    }

    static class Member {
        String name ;
        String company;

        public Member(){};
        public Member(String name, String company){
            this.name = name;
            this.company = company;

        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }
    }
}

package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {


    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService st1 = ac.getBean(StatefulService.class);
        StatefulService st2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자가 10000원 주문
        st1.order("userA", 10000);

        //ThreadA : B사용자가 20000원 주문
        st2.order("userB", 20000);

        //TreadA: 사용자A 주문금핵 조회
        //int price = st1.getPrice();
        System.out.println("price = " + st1);
        org.assertj.core.api.Assertions.assertThat(st1).isNotEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}

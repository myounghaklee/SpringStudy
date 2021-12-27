package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemeberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configuraationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemeberServiceImpl ms = ac.getBean("memberService", MemeberServiceImpl.class);
        OrderServiceImpl os = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository mr =  ac.getBean("memberRepository", MemberRepository.class);


        MemberRepository mr1 = ms.getMemberRepository();
        MemberRepository mr2 = os.getMemberRepository();

        System.out.println("memberService -> memberRepo : " + mr1);
        System.out.println("orderService -> memberRepo : " + mr2);
        System.out.println("memberRepository -> memberRepo : " + mr);

        Assertions.assertThat(ms.getMemberRepository()).isSameAs(mr);
        Assertions.assertThat(os.getMemberRepository()).isSameAs(mr);


    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = : " + bean.getClass());
        /* 결과
        call AppConfig.memberService
        23:57:51.675 [Test worker] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'memberRepository'
        call AppConfig.memberRepository
        23:57:51.677 [Test worker] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'orderService'
        call AppConfig.orderService
        23:57:51.679 [Test worker] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'discountPolicy'
        bean = : class hello.core.AppConfig$$EnhancerBySpringCGLIB$$6dbfdd22

         */
    }
}

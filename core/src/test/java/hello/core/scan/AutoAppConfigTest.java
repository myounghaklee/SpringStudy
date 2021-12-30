package hello.core.scan;

import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.AutoAppConfig;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService ms = ac.getBean(MemberService.class);
        //OrderService os = ac.getBean(OrderService.class);

        Assertions.assertThat(ms).isInstanceOf(MemberService.class);
        OrderServiceImpl os = ac.getBean(OrderServiceImpl.class);
        MemberRepository mr = os.getMemberRepository();
        System.out.println("========memberRepository : " + ms);
    }
}

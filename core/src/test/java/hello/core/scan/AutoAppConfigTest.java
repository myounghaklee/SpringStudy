package hello.core.scan;

import hello.core.member.MemberService;
import hello.core.AutoAppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService ms = ac.getBean(MemberService.class);

        Assertions.assertThat(ms).isInstanceOf(MemberService.class);
    }
}

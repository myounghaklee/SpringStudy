package hello.core.scope;

import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean sb1 = ac.getBean(SingletonBean.class);
        SingletonBean sb2 = ac.getBean(SingletonBean.class);
        System.out.println("ssss1" + sb1);
        System.out.println("ssss2" + sb2);
        assertThat(sb1).isSameAs(sb2);
    }

    @Scope("singleton")
    static class SingletonBean{
        @PostConstruct
        public void init(){
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("destroy");
        }


    }

}

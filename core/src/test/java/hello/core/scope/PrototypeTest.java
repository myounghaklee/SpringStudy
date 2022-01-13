package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        System.out.println("find prototypeBean1");
        SingletonBean sb1 = ac.getBean(SingletonBean.class);

        System.out.println("find prototypeBean2");
        SingletonBean sb2 = ac.getBean(SingletonBean.class);
        System.out.println("prototypeBean1: " + sb1);
        System.out.println("prototypeBean1: "+ sb2);
        assertThat(sb1).isNotSameAs(sb2);
        ac.close();
    }

    @Scope("prototype")
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

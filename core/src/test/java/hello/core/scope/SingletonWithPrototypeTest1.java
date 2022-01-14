package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean pb1 = ac.getBean(PrototypeBean.class);
        pb1.addCnt();

        Assertions.assertThat(pb1.getCnt()).isEqualTo(1);

        PrototypeBean pb2 = ac.getBean(PrototypeBean.class);
        pb2.addCnt();

        Assertions.assertThat(pb2.getCnt()).isEqualTo(1);

    }

    @Scope("prototype")
    static class PrototypeBean{
        private int cnt = 0;
        public void addCnt(){ cnt++; }

        public int getCnt(){
            return cnt;
        }

        @PostConstruct
        public void init(){
            System.out.println("cnt === : " + this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("destroy======");
        }



    }



}

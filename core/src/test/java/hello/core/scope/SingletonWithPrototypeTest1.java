package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

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

    @Test
    void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean cb1 = ac.getBean(ClientBean.class);
        int cnt1= cb1.logic();
        Assertions.assertThat(cnt1).isEqualTo(1);
        ClientBean cb2 = ac.getBean(ClientBean.class);
        int cnt2= cb1.logic();
        Assertions.assertThat(cnt2).isEqualTo(1);
    }
    @Scope("singleton")
    static class ClientBean{

        @Autowired
        private Provider<PrototypeBean> prototypeBeanProvider;

        public int logic(){
            PrototypeBean pb = prototypeBeanProvider.get();
            pb.addCnt();
            return pb.getCnt();
        }
    }


    @Scope("prototype")
    static class PrototypeBean{
        private int cnt = 0;
        public void addCnt(){
            cnt++;
        }

        public int getCnt(){
            return cnt;
        }

        @PostConstruct
        public void init(){
            System.out.println("cnt === : " + this + "  "+ cnt);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("destroy======");
        }



    }



}

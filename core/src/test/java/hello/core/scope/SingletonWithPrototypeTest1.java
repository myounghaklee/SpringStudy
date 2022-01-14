package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind(){

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

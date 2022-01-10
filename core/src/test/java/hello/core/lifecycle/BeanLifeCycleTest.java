package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifyCycleConfig.class);
        NetworkClient nc = ac.getBean(NetworkClient.class);
        ac.close();

    }

    @Configuration
    static class LifyCycleConfig{
//        @Bean(initMethod =  "init", destroyMethod = "close")
        public NetworkClient networkClient(){
            NetworkClient nc = new NetworkClient();
            nc.setUrl("http://hello-spring.dev");

            return nc;
        }
    }
}

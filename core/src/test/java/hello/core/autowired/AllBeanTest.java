package hello.core.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AllBeanTest {
    @Test
    void findAllBean(){
        new AnnotationConfigApplicationContext();
    }
}

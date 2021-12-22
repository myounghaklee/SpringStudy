package hello.core.beanfind;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모타입으로 조회시, 자식이 둘 이상 있으면 중복오류 발생")
    void findBeanByParentTypeDuplicate(){
        DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () ->ac.getBean(DiscountPolicy.class));
    }


    @Test
    @DisplayName("부모타입으로 조회시, 자식이 둘 이상 있으면 빈 이름을 지정하면 된다. ")
    void findBeanByParentTypBeanName(){
        DiscountPolicy rateDicountPolicy = ac.getBean("rateDiscountPolicy",DiscountPolicy.class);
        assertThat(rateDicountPolicy).isInstanceOf(RateDiscountPolicy.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () ->ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회 ")
    void findBeanBySubType(){
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);

        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () ->ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모타입 모두 타입으로 조회 ")
    void findBeanByParentType(){
        Map<String, DiscountPolicy> beanType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beanType.size()).isEqualTo(2);
        for (String s : beanType.keySet()) {
            System.out.println("Key = " + s + "value = " + beanType.get(s));

        }
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);

        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () ->ac.getBean(DiscountPolicy.class));
    }


    @Test
    @DisplayName("부모타입 모두 타입으로 조회 -object")
    void findBeanByObjectType(){
        Map<String, Object> beanType = ac.getBeansOfType(Object.class);
        //assertThat(beanType.size()).isEqualTo(2);
        for (String s : beanType.keySet()) {
            System.out.println("Key = " + s + "value = " + beanType.get(s));

        }

    }



    @Configuration
    static class TestConfig{

        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }

    }
}

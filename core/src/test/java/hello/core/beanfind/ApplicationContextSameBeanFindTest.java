package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입 조회시 같은 타입이 잇으면 중복 오류 발생 테스트")
    void findBeanByDuplicate() {
       // MemberRepository member = ac.getBean( MemberRepository.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, ()->ac.getBean(MemberRepository.class));
//        System.out.println("memberService = " + member);
//        System.out.println("memberService = " + member.getClass());
 //       assertThat(member).isInstanceOf(MemeberServiceImpl.class);
    }

    @Test
    @DisplayName("타입 조회시 같은 타입이 잇으면 빈 이름 지정 ")
    void findBeanByName() {
        MemberRepository member = ac.getBean( "memberRepository1",MemberRepository.class);
        assertThat(member).isInstanceOf(MemberRepository.class);
//        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, ()->ac.getBean(MemberRepository.class))
//        System.out.println("memberService = " + member);
//        System.out.println("memberService = " + member.getClass());
        //       assertThat(member).isInstanceOf(MemeberServiceImpl.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("key = " + s + "value = :" + beansOfType.get(s));
            
        }
    }



    @Configuration
    static class SameBeanConfig {

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}

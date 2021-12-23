package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemeberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("retrieve bean using bean name")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemeberServiceImpl.class);
    }

    @Test
    @DisplayName("retrieve bean using bean type")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemeberServiceImpl.class);
    }


    @Test
    @DisplayName("retrieve bean using Implememtation Type")
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService", MemeberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemeberServiceImpl.class);
    }

    @Test
    @DisplayName("Cant retrieve bean using Bean name")
    void findBeanByNameX() {

        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class, () ->ac.getBean("XXXX", MemberService.class));
       // org.junit.jupiter.api.Assertions.assertThrows()
    }
}



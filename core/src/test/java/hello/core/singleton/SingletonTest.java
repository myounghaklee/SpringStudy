package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("싱글톤 없는 순수한 DI Container")
    void pureContainer(){
        AppConfig ap = new AppConfig();
        //1. 조회 : 호출할때마다 객체를 생성
        MemberService memberService1 = ap.memberService();

        //2. 조회 : 호출할 때 마다 다른객체를 생성
        MemberService memberService2 = ap.memberService();

        //참조값이 다른것 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }


    @Test
    @DisplayName("싱클톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService ss1 = SingletonService.getInstance();
        SingletonService ss2 = SingletonService.getInstance();

        System.out.println("ss1 = " + ss1);
        System.out.println("ss2 = " + ss2);

        Assertions.assertThat(ss1).isNotSameAs(ss2);

        //same ==  대상의 주소값을 비교 참조랑 비교
        //equal ==  대상의 내용을 비교 
    }

}

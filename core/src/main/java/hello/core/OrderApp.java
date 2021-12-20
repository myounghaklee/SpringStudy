package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemeberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
ApplicationContext : 스프링 컨테이너라 한다.
스프링 컨테이너는 @Configuration이 붙은 AppConfig를 설정 정보로 사용한다.  @Bean 이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록한다.
이렇게 스프링 컨테이너에 등록된 객체를 스프링 빈이라 한다.
스프링 빈은 @Bean 이 붙은 메서드의 명을 스프링 빈으 ㅣ이름으로 사ㅛㅇ한다.

 */
public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService  = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);

    }
}

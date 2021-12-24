package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("싱글톤 없는 순수한 DI Container")
    void pureContainer(){
        AppConfig ap = new AppConfig();
        //1. 조회 : 호출할때마다 객체를 생성
        MemberService memberService1 = ap.memberService();
    }
}
